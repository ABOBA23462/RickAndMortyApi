package com.example.rickandmorty.data.network.apiservices

import com.example.rickandmorty.models.CharacterModel
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface CharacterApiService {

    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<CharacterModel>>
}