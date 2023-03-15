package com.example.rickandmorty.models

import com.google.gson.annotations.SerializedName

data class LocationsModel(

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("created")
    val created: String
)
