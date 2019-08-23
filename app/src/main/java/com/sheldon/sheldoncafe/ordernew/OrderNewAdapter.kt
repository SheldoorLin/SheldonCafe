package com.sheldon.sheldoncafe.ordernew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sheldon.sheldoncafe.`object`.ProductItem
import com.sheldon.sheldoncafe.databinding.ItemOrderNewUpRecyclerBinding

class OrderNewAdapter(val onClickListener: OnClickListener): ListAdapter<ProductItem, OrderNewAdapter.ItemViewHolder>(DiffCallback) {


    companion object DiffCallback : DiffUtil.ItemCallback<ProductItem>() {
        override fun areItemsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: ProductItem, newItem: ProductItem): Boolean {
            return oldItem.name == newItem.name
        }
    }


    class ItemViewHolder(private var binding: ItemOrderNewUpRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(productItem: ProductItem) {
            binding.productItem = productItem
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemOrderNewUpRecyclerBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val productItem = getItem(position)

//        //onClickListener Area
        holder.itemView.setOnClickListener {
            onClickListener.onClick(productItem)
        }
//        //onClickListener Area finish

        holder.bind(productItem)
    }

//    //onClickListener Area
    class OnClickListener(val clickListener: (productItem: ProductItem) -> Unit) {
        fun onClick(productItem: ProductItem) = clickListener(productItem)
    }
//    //onClickListener Area finish
}