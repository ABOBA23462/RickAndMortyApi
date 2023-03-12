package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.data.network.RetrofitClient
import com.example.rickandmorty.data.network.apiservices.CharacterApiService

class App: Application() {

    companion object{
        var characterApiService: CharacterApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApiService = RetrofitClient().providerCharacterApiService()
    }

}