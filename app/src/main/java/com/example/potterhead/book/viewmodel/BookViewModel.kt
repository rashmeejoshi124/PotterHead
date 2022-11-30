package com.example.potterhead.book.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.potterhead.api.BooksApi
import com.example.potterhead.model.Book
import com.example.potterhead.retrofit.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {

    private var _booksList = MutableLiveData<List<Book>>()
    val booksList: LiveData<List<Book>> = _booksList

    fun getAllBooks() = viewModelScope.launch(Dispatchers.IO) {
        val booksApi = RetrofitHelper.getInstance().create(BooksApi::class.java)
        val result = booksApi.getAllBooks()
        if (result.isSuccessful) {
            _booksList.postValue(result.body())
        }
    }

}