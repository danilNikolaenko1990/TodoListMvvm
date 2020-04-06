package com.daniln.testmvvm.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniln.testmvvm.R
import com.daniln.testmvvm.domain.Item

class ItemsAdapter() :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemsList: ArrayList<Item> = ArrayList()

    fun setup(items: List<Item>) {
        itemsList.clear()
        itemsList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView: View = layoutInflater.inflate(R.layout.cell, parent, false)

        return ViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int {
        return itemsList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.bind(itemsList[position])
        }
    }
}

class ViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private var itemCell: TextView = itemView.findViewById(R.id.itemCell)

    fun bind(item: Item) {
        itemCell.text = item.text
    }
}