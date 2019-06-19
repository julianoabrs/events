package com.example.events.api

import com.example.events.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class EventsRepository {
    private val retrofit =
        Retrofit.Builder().baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun eventsApi() = retrofit.create(EventsApi::class.java)
}