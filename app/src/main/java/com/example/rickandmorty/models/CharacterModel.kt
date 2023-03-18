package com.example.rickandmorty.models

import com.google.gson.annotations.SerializedName

data class CharacterModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("type")
    val type: String,
)