package com.example.potterhead.book.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potterhead.api.BooksApi
import com.example.potterhead.book.repo.BookRepository
import com.example.potterhead.book.repo.BookRepositoryImpl
import com.example.potterhead.model.Book
import com.example.potterhead.retrofit.RetrofitHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookRepository: BookRepository
) : ViewModel() {

    private var _booksList = MutableLiveData<List<Book>>()
    val booksList: LiveData<List<Book>> = _booksList

    fun getAllBooks() = viewModelScope.launch(Dispatchers.IO) {
        val result = bookRepository.getAllBooks()
        if (result.isSuccessful) {
            _booksList.postValue(result.body())
        } else {
            _booksList.postValue(emptyList())
        }
    }

}