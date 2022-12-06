package com.example.potterhead.di.module

import com.example.potterhead.api.BooksApi
import com.example.potterhead.book.repo.BookRepository
import com.example.potterhead.book.repo.BookRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl() = "https://legacy--api.herokuapp.com/"

    @Provides
    @Singleton
    fun provideRetrofit(BASE_URL: String): Retrofit =
        Retrofit.Builder()
//                .addConverterFactory(MoshiConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            //.client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun providesBooksApiService(retrofit: Retrofit): BooksApi = retrofit.create(BooksApi::class.java)

    @Provides
    @Singleton
    fun providesBookRepository(booksApi: BooksApi): BookRepository = BookRepositoryImpl(booksApi)

}