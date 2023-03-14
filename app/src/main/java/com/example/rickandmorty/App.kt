package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.data.network.RetrofitClient
import com.example.rickandmorty.data.network.apiservices.CharacterApiService
import com.example.rickandmorty.data.network.apiservices.EpisodeApiService
import com.example.rickandmorty.data.network.apiservices.LocationApiService

class App : Application() {

    companion object {
        var characterApiService: CharacterApiService? = null
        var locationApiService: LocationApiService? = null
        var episodeApiService: EpisodeApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApiService = RetrofitClient().providerCharacterApiService()
        locationApiService = RetrofitClient().providerLocationApiService()
        episodeApiService = RetrofitClient().providerEpisodeApiService()
    }
}