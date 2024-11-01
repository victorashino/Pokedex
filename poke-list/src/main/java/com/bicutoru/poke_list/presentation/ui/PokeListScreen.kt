package com.bicutoru.poke_list.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.bicutoru.network.model.PokeModel
import com.bicutoru.network.viewmodel.PokeListViewModel

@Composable
fun PokeListScreen(
    viewModel: PokeListViewModel = hiltViewModel()
) {

    val pokemons by viewModel.pokemonList.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getPokemons()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFEFFF0)),
        contentAlignment = Alignment.Center
    ) {
        when {
            isLoading -> {
                PokeListSkeleton()
            }

            error != null -> {
                Text(
                    text = error ?: "Unknown error",
                    color = Color.Red,
                    modifier = Modifier
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }

            else -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFFEFFF0))
                ) {
                    items(pokemons) { pokemon ->
                        PokemonItem(pokemon)
                    }
                }
            }
        }
    }
}

@Composable
private fun PokemonItem(pokemon: PokeModel) {
    Card(
        modifier = Modifier
            .background(Color(0xFFFEFFF0))
            .padding(8.dp)
            .height(190.dp)
            .width(150.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF201F1F))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            GifImage(
                imageUrl = pokemon.imageUrl,
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth(0.7f)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            )
        }
    }
}

@Composable
private fun GifImage(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (android.os.Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
        imageLoader = imageLoader
    )
}
