package com.example.events.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.events.api.EventsRepository
import com.example.events.models.EventModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private val events: MutableLiveData<ArrayList<EventModel>> = MutableLiveData()
    private val error: MutableLiveData<Boolean> = MutableLiveData()

    fun getEvents() = events

    fun getError() = error

    fun loadEvents() {
        val callEventModels = EventsRepository().eventsApi().getEvents()
        callEventModels.enqueue(object : Callback<ArrayList<EventModel>?> {
            override fun onResponse(
                call: Call<ArrayList<EventModel>?>?,
                response: Response<ArrayList<EventModel>?>?
            ) {
                response?.body()?.let {
                    events.postValue(it)
                } ?: run {
                    error.postValue(true)
                }
            }

            override fun onFailure(
                call: Call<ArrayList<EventModel>?>?,
                t: Throwable?
            ) {
                error.postValue(true)
            }
        })
    }
}