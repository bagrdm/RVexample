package com.example.rvexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rvexample.databinding.RecyclerItemBinding

private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<RoomModel>() {
    override fun areItemsTheSame(oldItem: RoomModel, newItem: RoomModel): Boolean {
        return oldItem.roomId == newItem.roomId
    }

    override fun areContentsTheSame(oldItem: RoomModel, newItem: RoomModel): Boolean {
        return oldItem == newItem
    }
}

class ExampleAdapter(private val listener: ButtonClickListener) :
    ListAdapter<RoomModel, ExampleAdapter.ExampleViewHolder>(ITEM_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val binding = RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        val holder = ExampleViewHolder(binding)

        binding.closeButton.setOnClickListener {
            listener.removeRoom(holder.adapterPosition)
        }

        binding.addChildButton.setOnClickListener {
            listener.addChild(holder.adapterPosition)
        }

        binding.addParentButton.setOnClickListener {
            listener.addParent(holder.adapterPosition)
        }

        binding.removeChildButton.setOnClickListener {
            listener.removeChild(holder.adapterPosition)
        }

        binding.removeParentButton.setOnClickListener {
            listener.removeParent(holder.adapterPosition)
        }

        return holder
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ExampleViewHolder(private val binding: RecyclerItemBinding) : ViewHolder(binding.root) {

        fun bind(item: RoomModel) {
            with(binding) {
                roomNum.text = item.roomId.toString()
                parentCount.text = item.parentCount.toString()
                childCount.text = item.childCount.toString()
            }
        }
    }
}
