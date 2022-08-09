package com.logical.virgin.adapter.bindingAdapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.logical.virgin.R

import com.squareup.picasso.Picasso

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromUrl(url: String) {
    Picasso.get().load(url).placeholder(R.drawable.ic_error_placeholder).into(this)
}

@BindingAdapter("checkNullValue")
fun TextView.setTextCustom(title: String?) {
    if (!title.isNullOrEmpty())
        this.text = title
    else
        this.text = "Unavailable"
}