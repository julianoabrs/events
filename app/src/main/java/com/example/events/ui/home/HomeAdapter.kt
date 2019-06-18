package com.example.events.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.events.databinding.EventItemListBinding
import com.example.events.models.EventModel
import java.util.*

class HomeAdapter constructor(context: Context, private var listOfData: ArrayList<EventModel>, val listener: OnEventClicked) : RecyclerView.Adapter<HomeViewHolder>() {

    override fun getItemCount(): Int {
        return listOfData.count()
    }

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeViewHolder {
        val eventItemListBinding = EventItemListBinding.inflate(layoutInflater, viewGroup, false)
        return HomeViewHolder(eventItemListBinding.root, eventItemListBinding)
    }

    override fun onBindViewHolder(viewHolder: HomeViewHolder, position: Int) {
        val event = listOfData[position]
        viewHolder.setData(event)
        viewHolder.itemView.setOnClickListener {
            listener.onEventClicked(event)
        }
    }

    interface OnEventClicked {
        fun onEventClicked(eventModel: EventModel)
    }

}