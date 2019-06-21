package com.example.events.api

import com.example.events.BuildConfig
import com.example.events.models.CheckinModel
import com.example.events.models.EventModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventsRepository {
    private val retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun eventsApi() = retrofit.create(EventsApi::class.java)

    fun getListEvents(eventResponse: EventResponse) {
        val callEventModels = eventsApi().getEvents()
        callEventModels.enqueue(object : Callback<ArrayList<EventModel>?> {
            override fun onResponse(
                call: Call<ArrayList<EventModel>?>?,
                response: Response<ArrayList<EventModel>?>?
            ) {
                response?.body()?.let {
                    eventResponse.success(it)
                } ?: run {
                    eventResponse.fail()
                }
            }

            override fun onFailure(
                call: Call<ArrayList<EventModel>?>?,
                t: Throwable?
            ) {
                eventResponse.fail()
            }
        })
    }

    fun doCheckIn(checkinModel: CheckinModel, eventResponse: EventResponse) {
        val call = eventsApi().checkin(checkinModel)
        call.enqueue(object : Callback<CheckinModel?> {
            override fun onResponse(call: Call<CheckinModel?>?, response: Response<CheckinModel?>?) {
                eventResponse.successPost()
            }

            override fun onFailure(call: Call<CheckinModel?>?, t: Throwable?) {
                eventResponse.fail()
            }
        })
    }
}