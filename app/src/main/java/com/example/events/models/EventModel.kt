package com.example.events.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EventModel(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("latitude")
    val latitude: Double,
    @SerializedName("longitude")
    val longitude: Double,
    @SerializedName("image")
    val image: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("date")
    val date: Long,
    @SerializedName("people")
    val people: List<PeopleModel>,
    @SerializedName("cupons")
    val cupons: List<CuponsModel>
) : Serializable