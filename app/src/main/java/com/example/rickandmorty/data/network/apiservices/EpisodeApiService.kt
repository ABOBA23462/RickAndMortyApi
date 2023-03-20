package com.example.rickandmorty.data.network.apiservices

import com.example.rickandmorty.models.CharacterModel
import com.example.rickandmorty.models.EpisodeModel
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisode(): Call<RickAndMortyResponse<EpisodeModel>>

    @GET("api/episode/{id}")
    fun fetchDetailEpisode(): Call<EpisodeModel>
}