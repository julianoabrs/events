package com.example.events

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.events.models.EventModel
import com.example.events.ui.details.DetailsFragment
import com.example.events.ui.home.HomeAdapter
import com.example.events.ui.home.HomeFragment

class MainActivity : AppCompatActivity(), HomeAdapter.OnEventClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.root_layout, HomeFragment.newInstance(), "home").commit()
        }
    }

    override fun onEventClicked(eventModel: EventModel) {
        val detailsFragment = DetailsFragment.newInstance(eventModel)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.root_layout, detailsFragment, "details")
            .addToBackStack(null)
            .commit()
    }
}
