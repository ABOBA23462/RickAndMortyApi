package com.example.rickandmorty.data.network.apiservices

import com.example.rickandmorty.models.LocationsModel
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationApiService {

    @GET("api/location")
    fun fetchLocation(): Call<RickAndMortyResponse<LocationsModel>>
}