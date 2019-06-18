package com.example.events.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.events.R
import com.example.events.models.EventModel

class HomeFragment : Fragment() {

    private var eventModels: ArrayList<EventModel> = arrayListOf()
    private lateinit var listener: HomeAdapter.OnEventClicked

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is HomeAdapter.OnEventClicked) {
            listener = context
        } else {
            throw ClassCastException(context.toString() + " must implement OnEventClicked.")
        }

        val names = context?.resources!!.getStringArray(R.array.names)
        val descriptions = context.resources!!.getStringArray(R.array.descriptions)

        names.forEachIndexed { index, element ->
            eventModels.add(EventModel(element, descriptions[index]))
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.home_fragment, container, false)
        val activity = activity as Context
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(activity, 1)
        recyclerView.adapter = HomeAdapter(activity, eventModels, listener)
        return view
    }
}