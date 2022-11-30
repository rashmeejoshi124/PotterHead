package com.example.potterhead.api

import com.example.potterhead.model.Book
import com.example.potterhead.model.BookList
import retrofit2.Response
import retrofit2.http.HTTP

interface BooksApi {

    @HTTP(method = "GET", path = "/api/v1/books", hasBody = false)
    suspend fun getAllBooks(): Response<List<Book>>
}