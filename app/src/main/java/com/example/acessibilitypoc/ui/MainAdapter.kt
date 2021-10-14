package com.example.acessibilitypoc.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.acessibilitypoc.R
import com.example.acessibilitypoc.data.Items
import com.example.acessibilitypoc.databinding.RecyclerItemsBinding

class MainAdapter(
    private val itemList: List<Items>
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(view: RecyclerItemsBinding) : RecyclerView.ViewHolder(view.root) {
        val title = view.txTitle
        val value = view.txValue
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_items, parent, false)
        val binding = RecyclerItemsBinding.bind(view)
        val viewHolder = ViewHolder(binding)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.title.text = item.name
        holder.value.text = "R$ ${item.value}"
    }

    override fun getItemCount(): Int = itemList.size
}