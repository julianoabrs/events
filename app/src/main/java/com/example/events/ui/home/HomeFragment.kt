package com.example.events.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.events.R
import com.example.events.models.EventModel

class HomeFragment : Fragment() {
    private lateinit var listener: HomeAdapter.OnEventClicked
    private lateinit var recyclerView: RecyclerView
    private lateinit var txtError: TextView

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
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.home_fragment, container, false)
        val activity = activity as Context
        recyclerView = view.findViewById(R.id.recycler_view)
        txtError = view.findViewById(R.id.txtError)

        txtError.visibility = View.GONE
        recyclerView.layoutManager = GridLayoutManager(activity, 1)

        val viewModelHome = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModelHome.getEvents().observe(this, Observer<ArrayList<EventModel>>{ events ->
            txtError.visibility = View.GONE
            recyclerView.adapter = HomeAdapter(activity, events, listener)
        })

        viewModelHome.getError().observe(this, Observer<Boolean> {
            txtError.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE

            txtError.text = context?.getText(R.string.error)
        })

        viewModelHome.loadEvents()
        return view
    }
}