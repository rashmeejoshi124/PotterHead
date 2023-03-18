package com.example.potterhead.di.module

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.potterhead.base.BaseAdapter
import com.example.potterhead.model.BaseClass
import com.example.potterhead.util.GlideUtil

@BindingAdapter("setAdapter")
fun setAdapter(
    recyclerView: RecyclerView,
    adapter: BaseAdapter<ViewDataBinding, BaseClass>?
) {
    adapter?.let {
        recyclerView.adapter = it
    }
}

@Suppress("UNCHECKED_CAST")
@BindingAdapter("submitList")
fun submitList(recyclerView: RecyclerView, list: List<BaseClass>?) {
    val adapter = recyclerView.adapter as BaseAdapter<ViewDataBinding, BaseClass>?
    adapter?.updateData(list ?: listOf())
}

@BindingAdapter("setImage")
fun setImage(imageView: AppCompatImageView, imageUrl: String) {
    GlideUtil.loadImage(imageUrl, imageView)
}
