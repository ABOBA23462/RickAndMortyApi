package com.example.rickandmorty.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repositories.EpisodeRepository
import com.example.rickandmorty.models.EpisodeModel
import com.example.rickandmorty.models.RickAndMortyResponse

class EpisodeViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepository()

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        return episodeRepository.fetchEpisode()
    }

    fun fetchDetailEpisode(id: Int): MutableLiveData<EpisodeModel> {
        return episodeRepository.fetchDetailEpisode(id)
    }
}