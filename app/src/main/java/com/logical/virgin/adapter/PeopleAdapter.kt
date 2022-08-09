package com.logical.virgin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.logical.virgin.databinding.ItemViewPeopleBinding
import com.logical.virgin.models.people.PeopleModelItem
import com.logical.virgin.util.DataDiffUtil


class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.MyViewHolder>() {
    private var people = emptyList<PeopleModelItem>()

    class MyViewHolder(private val binding: ItemViewPeopleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(person: PeopleModelItem) {
            binding.person = person
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemViewPeopleBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentPerson=people[position]
        holder.bind(currentPerson)

    }

    override fun getItemCount(): Int {
       return people.size
    }
    fun setData(newData:List<PeopleModelItem>){
        val recipesDiffUtil= DataDiffUtil(people,newData)
        val diffUtilResult=DiffUtil.calculateDiff(recipesDiffUtil)
        people=newData
        diffUtilResult.dispatchUpdatesTo(this)
    }
}