package com.example.dogs

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogs.databinding.DogItemBinding
import com.squareup.picasso.Picasso


class DogAdapter : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {
    private val dogImageList = ArrayList<String?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = DogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DogViewHolder(binding)
    }

    override fun getItemCount() = dogImageList.count()

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        dogImageList[position]?.let {
            holder.bind(it)
        }
    }

    fun updateDataset(dataset: List<String?>) {
        Log.d("**logged", "adding data ${dataset.size}")
        dogImageList.clear()
        dogImageList.addAll(dataset)

        notifyDataSetChanged()
    }

    class DogViewHolder(private val binding: DogItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(img: String) {
            Log.d("**logged", "loading img $img")
            Picasso.get().load(img).fit().into(binding.dogImage)
        }
    }

    // add diffutil if time permits
}