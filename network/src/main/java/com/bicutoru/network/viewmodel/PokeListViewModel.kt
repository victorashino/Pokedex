package com.bicutoru.network.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bicutoru.network.di.DispatcherIO
import com.bicutoru.network.model.PokeModel
import com.bicutoru.network.repository.PokeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokeListViewModel @Inject constructor(
    private val repository: PokeRepository,
    @DispatcherIO private val dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _pokemonList = MutableStateFlow<List<PokeModel>>(emptyList())
    val pokemonList: StateFlow<List<PokeModel>> = _pokemonList

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun getPokemons() = viewModelScope.launch(dispatcher) {
        _isLoading.value = true

        try {
            val result = repository.getPokemons()

            result.fold(
                onSuccess = { pokeResponse ->
                    val deferredPokemons = pokeResponse.pokemons.map { pokemon ->
                        async {
                            repository.getPokemonDetails(pokemon.url)
                        }
                    }

                    val pokemons = deferredPokemons.mapNotNull { deferred ->
                        deferred.await().getOrNull()
                    }

                    _pokemonList.value = pokemons
                },
                onFailure = { throwable ->
                    _error.value = throwable.message
                }
            )
        } catch (e: Exception) {
            _error.value = e.message
        } finally {
            _isLoading.value = false
        }
    }
}
