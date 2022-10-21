package com.example.shaditask.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shaditask.data.model.ApiResponse
import com.example.shaditask.databinding.ItemLayoutBinding

class ProfileAdapter(
    private val data: ArrayList<ApiResponse.Result?>
) : RecyclerView.Adapter<ProfileAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemData: ApiResponse.Result?) {
            binding.tvName.text = "${itemData?.name?.title}. ${itemData?.name?.first} ${itemData?.name?.last}"
            binding.tvAge.text = "${itemData?.dob?.age} Years"
            binding.tvAddress.text = "${itemData?.location?.city}, ${itemData?.location?.state}"
            Glide.with(binding.ivProfile.context)
                .load(itemData?.picture?.large)
                .into(binding.ivProfile)
        }
    }
}