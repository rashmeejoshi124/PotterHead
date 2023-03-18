package com.example.potterhead.book.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.potterhead.R
import com.example.potterhead.base.BaseAdapter
import com.example.potterhead.base.ItemClickListener
import com.example.potterhead.databinding.BookItemBinding
import com.example.potterhead.model.Book

class BookListAdapter(val list: List<Book>, val bookListener: ItemClickListener) :
    BaseAdapter<BookItemBinding, Book>(list) {

    override val layoutId: Int
        get() = R.layout.book_item

    override fun bind(binding: BookItemBinding, item: Book) {
        binding.apply {
            book = item
            listener = bookListener
            executePendingBindings()
        }
    }
}