package com.example.bootcounter.presentation.boot.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcounter.R
import com.example.bootcounter.data.boot.model.BootEvent

class BootInfoListAdapter : RecyclerView.Adapter<BootInfoListViewHolder>(){

    private val data: MutableList<BootEvent> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BootInfoListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.boot_event_info_line, parent, false)
        return BootInfoListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BootInfoListViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun updateData(newList: List<BootEvent>) {
        data.clear()
        data.addAll(newList)
        notifyDataSetChanged()
    }


}