package com.example.rickandmorty.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.App
import com.example.rickandmorty.models.LocationsModel
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationViewModel : ViewModel() {

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<LocationsModel>> {
        val data: MutableLiveData<RickAndMortyResponse<LocationsModel>> = MutableLiveData()
        App.locationApiService?.fetchLocation()
            ?.enqueue(object : Callback<RickAndMortyResponse<LocationsModel>> {

                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationsModel>>,
                    response: Response<RickAndMortyResponse<LocationsModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationsModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}