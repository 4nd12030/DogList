package com.cursokotlin.doglist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.cursokotlin.doglist.databinding.ItemDogBinding
import com.squareup.picasso.Picasso

class DogViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemDogBinding.bind(view)
    val ivDog = binding.ivDog

    fun bind(image: String) {
        Picasso.get().load(image).into(ivDog)
    }

}