package com.example.events.api

import com.example.events.models.EventModel

interface EventResponse {

    fun success(events: ArrayList<EventModel>)

    fun successPost()

    fun fail()
}