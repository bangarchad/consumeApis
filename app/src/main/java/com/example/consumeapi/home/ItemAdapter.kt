package com.example.consumeapi.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.consumeapi.databinding.RvListBinding
import com.example.consumeapi.network.GithubData

class ItemAdapter : ListAdapter<GithubData, ItemAdapter.ItemViewHolder> (DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(RvListBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ItemViewHolder(private var binding: RvListBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(githubData: GithubData){
            binding.item = githubData

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<GithubData>() {

        override fun areItemsTheSame(oldItem: GithubData, newItem: GithubData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: GithubData, newItem: GithubData): Boolean {
            return oldItem.id == newItem.id
        }
    }

}