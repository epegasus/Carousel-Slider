package dev.pegasus.carouselslider.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dev.pegasus.carouselslider.databinding.ItemCarouselBinding

/**
 * @Author: SOHAIB AHMED
 * @Date: 16,May,2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */

class AdapterCarousel : ListAdapter<String, AdapterCarousel.CustomViewHolder>(customDiffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCarouselBinding.inflate(layoutInflater, parent, false)
        return CustomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.binding.mtvTitle.text = getItem(position)
    }

    inner class CustomViewHolder(val binding: ItemCarouselBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val customDiffUtils = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }
        }
    }
}