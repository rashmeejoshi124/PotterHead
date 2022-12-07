package com.example.potterhead.book.repo

import com.example.potterhead.api.BooksApi
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(private val booksApi: BooksApi) : BookRepository {

    override suspend fun getAllBooks() = booksApi.getAllBooks()
}