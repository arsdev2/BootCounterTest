package com.example.bootcounter.presentation.boot.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bootcounter.R
import com.example.bootcounter.data.boot.model.BootEvent
import org.w3c.dom.Text

class BootInfoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView by lazy { itemView.findViewById(R.id.boot_event_info) }

    fun bind(model: BootEvent) {
        title.text = "${model.id} - ${model.timestamp}"
    }

}