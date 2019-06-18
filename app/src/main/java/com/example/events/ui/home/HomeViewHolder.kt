package com.example.events.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.events.databinding.EventItemListBinding
import com.example.events.models.EventModel


class HomeViewHolder constructor(itemView: View, private val eventItemListBinding: EventItemListBinding) : RecyclerView.ViewHolder(itemView) {
    fun setData(eventModel: EventModel) {
        eventItemListBinding.eventModel = eventModel
    }
}