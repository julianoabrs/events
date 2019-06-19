package com.example.events.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.events.R
import com.example.events.databinding.EventDetailFragmentBinding
import com.example.events.models.EventModel

class DetailsFragment: Fragment() {
    private lateinit var btnCheckin: Button


    companion object {
        private const val EVENT = "event"

        fun newInstance(eventModel: EventModel): DetailsFragment {
            val args = Bundle()
            args.putSerializable(EVENT, eventModel)
            val fragment = DetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.event_detail_fragment, container, false)
        btnCheckin = view.findViewById(R.id.btnCheckin)

        btnCheckin.setOnClickListener {

        }

        val eventDetailFragmentBinding = EventDetailFragmentBinding.inflate(inflater, container, false)

        eventDetailFragmentBinding.eventModel = arguments!!.getSerializable(EVENT) as EventModel
        return eventDetailFragmentBinding.root
    }
}