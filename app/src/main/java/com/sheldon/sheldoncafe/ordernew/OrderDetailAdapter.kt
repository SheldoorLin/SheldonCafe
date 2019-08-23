package com.sheldon.sheldoncafe.ordernew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sheldon.sheldoncafe.`object`.ProductItem
import com.sheldon.sheldoncafe.databinding.ItemOrderNewDetailRecyclerBinding

class OrderDetailAdapter(val viewModel: OrderNewViewModel) :
    ListAdapter<ProductItem, OrderDetailAdapter.ItemViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem.name == newItem.name
        }
    }


    class ItemViewHolder(private var binding: ItemOrderNewDetailRecyclerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(productItem: ProductItem, viewModel: OrderNewViewModel) {
            binding.productItem = productItem
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemOrderNewDetailRecyclerBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val productItem = getItem(position)

        holder.bind(productItem,viewModel)
    }
}