package com.example.potterhead.book.repo

import com.example.potterhead.api.BooksApi
import com.example.potterhead.model.Book
import retrofit2.Response
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(val booksApi: BooksApi) : BookRepository {

    override suspend fun getAllBooks(): Response<List<Book>> {
        // val booksApi = RetrofitHelper.getInstance().create(BooksApi::class.java)
        return booksApi.getAllBooks()
    }
}