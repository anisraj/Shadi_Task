package com.example.shaditask.presentation.view

import android.view.LayoutInflater
import android.view.View
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
            if (itemData?.isAccepted == true) {
                binding.llBtns.visibility = View.GONE
                binding.llAction.visibility = View.VISIBLE
                binding.tvAction.text = "Profile Accepted"
            } else if (itemData?.isRejected == true) {
                binding.llBtns.visibility = View.GONE
                binding.llAction.visibility = View.VISIBLE
                binding.tvAction.text = "Profile Rejected"
            } else {
                binding.llBtns.visibility = View.VISIBLE
                binding.llAction.visibility = View.GONE
            }
            binding.tvName.text = "${itemData?.name?.title} ${itemData?.name?.first} ${itemData?.name?.last}"
            binding.tvAge.text = "${itemData?.dob?.age}"
            binding.tvAddress.text = "${itemData?.location?.city} ${itemData?.location?.state}"
            Glide.with(binding.ivProfile.context)
                .load(itemData?.picture?.large)
                .into(binding.ivProfile)
            binding.btnAccept.setOnClickListener {
                onAcceptClickListener?.let {
                    if (itemData != null) {
                        it(itemData)
                    }
                }
            }
            binding.btnReject.setOnClickListener {
                onRejectClickListener?.let {
                    if (itemData != null) {
                        it(itemData)
                    }
                }
            }
        }
    }

    private var onAcceptClickListener: ((ApiResponse.Result) -> Unit)? = null
    fun setAcceptClickListener(listener: (ApiResponse.Result) -> Unit) {
        onAcceptClickListener = listener
    }
    private var onRejectClickListener: ((ApiResponse.Result) -> Unit)? = null
    fun setRejectClickListener(listener: (ApiResponse.Result) -> Unit) {
        onRejectClickListener = listener
    }

}