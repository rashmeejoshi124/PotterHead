package com.example.potterhead.book.repo

import com.example.potterhead.api.BooksApi
import com.example.potterhead.model.Book
import com.example.potterhead.retrofit.RetrofitHelper
import retrofit2.Response

class BookRepositoryImpl: BookRepository {

    override suspend fun getAllBooks(): Response<List<Book>> {
        val booksApi = RetrofitHelper.getInstance().create(BooksApi::class.java)
        return booksApi.getAllBooks()
    }
}