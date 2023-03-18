package com.example.potterhead

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.potterhead.base.ItemClickListener
import com.example.potterhead.book.adapter.BookListAdapter
import com.example.potterhead.book.viewmodel.BookViewModel
import com.example.potterhead.databinding.FragmentMainBinding
import com.example.potterhead.model.BaseClass
import com.example.potterhead.model.Book
import com.example.potterhead.util.GlideUtil
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(), ItemClickListener {

    private lateinit var binding: FragmentMainBinding
    private val vm: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        binding.apply {
            viewModel = vm
            lifecycleOwner = this@MainFragment
            adapter = BookListAdapter(listOf(), this@MainFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
    }

    override fun onItemClicked(item: BaseClass) {
        if (item is Book) {
            Toast.makeText(context, "book - ${item.title}", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setClickListeners() {
        binding.books.setOnClickListener {
            vm.getAllBooks()
        }
    }

    companion object {
        const val TAG = "MainFragment"
    }
}