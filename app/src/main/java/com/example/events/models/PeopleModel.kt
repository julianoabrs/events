package com.example.events.models

import com.google.gson.annotations.SerializedName

data class PeopleModel(

    @SerializedName("id") val id: Int,
    @SerializedName("eventId") val eventId: Int,
    @SerializedName("name") val name: String,
    @SerializedName("picture") val picture: String
)