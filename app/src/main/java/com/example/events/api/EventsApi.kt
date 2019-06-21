package com.example.events.api

import com.example.events.models.CheckinModel
import com.example.events.models.EventModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EventsApi {
    @GET("events")
    fun getEvents(): Call<ArrayList<EventModel>>

    @GET("events/{idEvent}")
    fun getEventById(@Path("idEvent") idEvent: String): Call<EventModel>

    @POST("checkin")
    fun checkin(@Body checkinModel: CheckinModel): Call<CheckinModel>
}