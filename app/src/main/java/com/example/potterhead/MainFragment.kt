package com.example.potterhead

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.potterhead.book.viewmodel.BookViewModel
import com.example.potterhead.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val vm: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        setObservers()
    }

    private fun setObservers() {
        vm.booksList.observe(viewLifecycleOwner) {
            val bookList = mutableListOf<String>()
            it.forEach { book ->
                bookList.add(book.imageUrl)
            }
            binding.bookList.text = bookList.toString()
            Glide.with(binding.root).load(bookList[0]).into(binding.image)
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