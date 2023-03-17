package com.example.rickandmorty.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.App
import com.example.rickandmorty.models.EpisodeModel
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepository {

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        val data: MutableLiveData<RickAndMortyResponse<EpisodeModel>> = MutableLiveData()
        App.episodeApiService?.fetchEpisode()
            ?.enqueue(object : Callback<RickAndMortyResponse<EpisodeModel>> {

                override fun onResponse(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    response: Response<RickAndMortyResponse<EpisodeModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}