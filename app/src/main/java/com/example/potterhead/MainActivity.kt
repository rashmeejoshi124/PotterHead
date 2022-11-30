package com.example.potterhead

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.potterhead.api.BooksApi
import com.example.potterhead.databinding.ActivityMainBinding
import com.example.potterhead.retrofit.RetrofitHelper


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
    }

    private fun setListeners() {
        binding.books.setOnClickListener {
            fetchBooks()
        }
    }

    private fun fetchBooks() {
        val booksApi = RetrofitHelper.getInstance().create(BooksApi::class.java)

        lifecycleScope.launchWhenCreated {
            val result = booksApi.getAllBooks()
            Log.d(TAG, "Result: ${result.body()}")
        }
    }

    companion object {
        const val TAG = "MainActivity"
    }
}