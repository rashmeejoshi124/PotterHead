package com.example.potterhead.model

data class Book(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val releaseDate: String
): BaseClass()


data class BookList(
    val bookList: List<Book>
): BaseClass()