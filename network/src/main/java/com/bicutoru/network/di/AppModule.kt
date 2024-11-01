package com.bicutoru.network.di

import com.bicutoru.network.common.RetrofitClient
import com.bicutoru.network.remote.PokeServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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