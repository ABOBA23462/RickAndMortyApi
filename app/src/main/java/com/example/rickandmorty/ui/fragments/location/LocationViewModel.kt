package com.example.rickandmorty.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repositories.LocationRepository
import com.example.rickandmorty.models.LocationsModel
import com.example.rickandmorty.models.RickAndMortyResponse

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationsModel>> {
        return locationRepository.fetchLocation()
    }
    fun fetchDetailLocation(id: Int): MutableLiveData<RickAndMortyResponse<LocationsModel>> {
        return locationRepository.fetchDetailLocation(id)
    }
}