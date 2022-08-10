package com.logical.virgin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.logical.virgin.databinding.ItemViewPeopleBinding
import com.logical.virgin.models.people.PeopleModelItem
import com.logical.virgin.util.DataDiffUtil


class PeopleAdapter(private val listener: ItemClicked) :
    RecyclerView.Adapter<PeopleAdapter.MyViewHolder>() {
    private var people = emptyList<PeopleModelItem>()

    class MyViewHolder(private val binding: ItemViewPeopleBinding, private val listener: ItemClicked) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(person: PeopleModelItem) {
            binding.person = person
            binding.executePendingBindings()
            binding.cvRootLayout.setOnClickListener {
                listener.onItemClicked(person)
            }
        }


        companion object {
            fun from(parent: ViewGroup, listener: ItemClicked): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewPeopleBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding, listener)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent, listener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentPerson = people[position]
        holder.bind(currentPerson)


    }

    override fun getItemCount(): Int {
        return people.size
    }

    fun setData(newData: List<PeopleModelItem>) {
        val recipesDiffUtil = DataDiffUtil(people, newData)
        val diffUtilResult = DiffUtil.calculateDiff(recipesDiffUtil)
        people = newData
        diffUtilResult.dispatchUpdatesTo(this)
    }
}

interface ItemClicked {
    fun onItemClicked(currentPerson: PeopleModelItem)
}