package com.example.potterhead.book.repo

import com.example.potterhead.model.Book
import retrofit2.Response

interface BookRepository {

    suspend fun getAllBooks(): Response<List<Book>>

}