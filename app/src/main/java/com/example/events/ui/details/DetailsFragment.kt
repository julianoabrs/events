package com.example.events.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.events.R
import com.example.events.databinding.EventDetailFragmentBinding
import com.example.events.models.EventModel

class DetailsFragment: Fragment() {

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
        val eventDetailFragmentBinding = EventDetailFragmentBinding.inflate(inflater, container, false)

        eventDetailFragmentBinding.eventModel = arguments!!.getSerializable(EVENT) as EventModel
        return eventDetailFragmentBinding.root
    }
}