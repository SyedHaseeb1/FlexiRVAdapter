package com.hsb.flexiadapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Developed by Syed Haseeb
 * Modified on Feb 12, 2024
 */

/**
 * Example use-case in activity
 *          val flexiRVAdapter = FlexiRVAdapter<ItemTypeModel,YourItemViewBinding>
 *
 *          flexiRVAdapter = FlexiRVAdapter(YourItemViewBinding::inflater)
 *
 *          flexiRVAdapter.viewHolderBinderCallback = { your_model ->
 *                 val titleStr = your_model.title
 *                 val descStr = your_model.desc
 *
 *                 tvTile.text = titleStr
 *                 tvDesc.text = descStr
 *
 *                 itemView.safeClickListener {
 *                 //handle clicks
 *
 *                 }
 *
 *             }
 *
 *             flexiRVAdapter.submitList(your_list)
 *             your_RV.layoutManager = verticalRv()
 *             your_RV.adapter = flexiRVAdapter
 *
 *             //To refresh adapter with new list:
 *             adapter.submitList(your_new_list)
 *
 *___________________________________THAT'S IT____
 */

class FlexiRVAdapter<T, VB : ViewBinding>(
    private val inflater: (LayoutInflater, ViewGroup, Boolean) -> VB,
) : ListAdapter<T, FlexiRVAdapter<T, VB>.ViewHolder>(DefaultDiffCallback()) {
    var viewHolderBinderCallback: (VB.(T) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = inflater.invoke(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(val binding: VB) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T) {
            binding.apply {
                viewHolderBinderCallback?.invoke(this, item)
            }
        }

    }

    private class DefaultDiffCallback<T> : DiffUtil.ItemCallback<T>() {
        override fun areItemsTheSame(oldItem: T & Any, newItem: T & Any) = oldItem == newItem

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: T & Any, newItem: T & Any) = oldItem == newItem
    }
}
