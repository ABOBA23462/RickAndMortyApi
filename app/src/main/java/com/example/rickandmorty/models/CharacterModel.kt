package com.example.rickandmorty.models

import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("image")
val image: String,

    @SerializedName("episode")
    val episode: Array<String>



)