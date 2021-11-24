package com.example.contreyandflag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contreyandflag.databinding.GridViewItemBinding
import com.example.contreyandflag.network.FlagPhoto
import com.example.contreyandflag.network.arraylist

class PhotoGridAdapter:ListAdapter<FlagPhoto,PhotoGridAdapter.FlagPhotoViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoGridAdapter.FlagPhotoViewHolder {
        return FlagPhotoViewHolder(GridViewItemBinding.inflate(
            LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.FlagPhotoViewHolder, position: Int) {
       val flagPhoto = getItem(position)
        holder.bind(flagPhoto)
    }
    class FlagPhotoViewHolder(private var binding:
                              GridViewItemBinding
    ):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(flagPhoto: FlagPhoto) {
            binding.photo = flagPhoto
            binding.executePendingBindings()
        }

    }
    companion object DiffCallback : DiffUtil.ItemCallback<FlagPhoto>() {
        override fun areItemsTheSame(oldItem: FlagPhoto, newItem: FlagPhoto): Boolean {
            return oldItem.name==newItem.name
        }

        override fun areContentsTheSame(oldItem: FlagPhoto, newItem: FlagPhoto): Boolean {
            return oldItem.flag==newItem.flag
        }
    }

}
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<FlagPhoto>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)

}