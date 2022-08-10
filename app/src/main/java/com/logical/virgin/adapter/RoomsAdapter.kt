package com.logical.virgin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.logical.virgin.databinding.RoomLayoutBinding
import com.logical.virgin.models.rooms.RoomsModelItem
import com.logical.virgin.util.DataDiffUtil


class RoomsAdapter() :
    RecyclerView.Adapter<RoomsAdapter.MyViewHolder>() {
    private var rooms = emptyList<RoomsModelItem>()

    class MyViewHolder(private val binding: RoomLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(room: RoomsModelItem) {
            binding.room = room
            binding.executePendingBindings()
        }


        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RoomLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentRoom = rooms[position]
        holder.bind(currentRoom)


    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    fun setData(newData: List<RoomsModelItem>) {
        val recipesDiffUtil = DataDiffUtil(rooms, newData)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        rooms = newData
        diffUtilResult.dispatchUpdatesTo(this)
    }
}