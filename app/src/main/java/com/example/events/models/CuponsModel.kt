package com.example.events.models

import com.google.gson.annotations.SerializedName

data class CuponsModel(

    @SerializedName("id") val id: Int,
    @SerializedName("eventId") val eventId: Int,
    @SerializedName("discount") val discount: Int
)