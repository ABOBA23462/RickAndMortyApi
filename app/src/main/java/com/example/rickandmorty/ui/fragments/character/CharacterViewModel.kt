package com.example.rickandmorty.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.App
import com.example.rickandmorty.models.CharacterModel
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class CharacterViewModel : ViewModel() {

    init {
        fetchCharacters()
    }

    fun fetchCharacters(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        val data: MutableLiveData<RickAndMortyResponse<CharacterModel>> = MutableLiveData()
        App.characterApiService?.fetchCharacters()
            ?.enqueue(object : Callback<RickAndMortyResponse<CharacterModel>> {

                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}