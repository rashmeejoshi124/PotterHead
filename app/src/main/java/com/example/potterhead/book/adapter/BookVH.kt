package com.example.potterhead.book.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.potterhead.databinding.BookItemBinding
import com.example.potterhead.model.Book
import com.example.potterhead.util.GlideUtil

class BookVH(private val binding: BookItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(book: Book) {
        binding.ivBookPoster.post {
            GlideUtil.loadImage(
                book.imageUrl,
                binding.ivBookPoster
            )
        }
    }
}