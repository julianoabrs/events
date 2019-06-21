package com.example.events.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CheckinModel(
    @SerializedName("eventId")
    val eventId: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String
) : Serializable