package com.bicutoru.data.di

import com.bicutoru.data.common.RetrofitClient
import com.bicutoru.data.remote.PokeServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return RetrofitClient.retrofitInstance
    }

    @Provides
    fun providePokeService(retrofit: Retrofit): PokeServiceApi {
        return retrofit.create(PokeServiceApi::class.java)
    }
}