package com.example.events.models

import java.io.Serializable

data class EventModel(
    val name: String,
    val description: String
) : Serializable