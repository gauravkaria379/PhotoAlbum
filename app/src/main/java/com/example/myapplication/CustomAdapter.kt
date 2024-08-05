package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ItemDesignBinding
import models.DataModel


class CustomAdapter(private val context: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    private var photoList = ArrayList<DataModel>()

    fun setPhotoList(list: List<DataModel>) {
        this.photoList = list as ArrayList<DataModel>
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context)
            .load(photoList[position].thumbnailUrl)
            .into(holder.binding.ivThumb)
    }

    override fun getItemCount(): Int {
        return photoList.size
    }

    class ViewHolder(val binding: ItemDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemDesignBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

}