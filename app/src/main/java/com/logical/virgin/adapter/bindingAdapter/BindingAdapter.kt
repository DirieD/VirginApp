package com.logical.virgin.adapter.bindingAdapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.logical.virgin.R
import com.logical.virgin.util.Constants.Companion.ROOM_IMAGE

import com.squareup.picasso.Picasso

@BindingAdapter("loadFromUrl")
fun ImageView.loadFromUrl(url: String) {
    Picasso.get().load(url).placeholder(R.drawable.ic_error_placeholder).into(this)
}
@BindingAdapter("loadOfficePic")
fun ImageView.loadOfficePic(str:String) {
    Picasso.get().load(ROOM_IMAGE).placeholder(R.drawable.ic_error_placeholder).into(this)
}

@BindingAdapter("checkNullValue")
fun TextView.setTextCustom(title: String?) {
    if (!title.isNullOrEmpty())
        this.text = title
    else
        this.text = "Unavailable"
}
@BindingAdapter("checkIsOccupied")
fun TextView.checkIsOccupied(occupied: Boolean?) {
    if (occupied == true)
        this.text = "Occupied"
    else
        this.text = "Available"
}
@BindingAdapter("createdAt")
fun TextView.createdAt(title: String?) {
    if (!title.isNullOrEmpty())
        this.text = "Created at: $title"
    else
        this.text = "Created at: don't know"
}@BindingAdapter("maxOccupancy")
fun TextView.maxOccupancy(max: Int?) {
    if (max!=null)
        this.text = "Max occupancy: $max"
    else
        this.text = "Max occupancy: don't know"
}