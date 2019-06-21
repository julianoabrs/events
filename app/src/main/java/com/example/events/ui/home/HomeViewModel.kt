package com.example.events.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events.api.EventResponse
import com.example.events.api.EventsRepository
import com.example.events.models.EventModel

class HomeViewModel : ViewModel(), EventResponse {

    private val events: MutableLiveData<ArrayList<EventModel>> = MutableLiveData()
    private val error: MutableLiveData<Boolean> = MutableLiveData()

    override fun success(eventsList: ArrayList<EventModel>) {
        events.postValue(eventsList)
    }

    override fun fail() {
        error.postValue(true)
    }

    override fun successPost() {
        //
    }

    fun getEvents() = events

    fun getError() = error

    fun loadEvents() {
        EventsRepository().getListEvents(this)
    }
}