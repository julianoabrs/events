package com.example.events.models

import java.io.Serializable

data class EventModel(
    val title: String,
    val description: String
) : Serializable