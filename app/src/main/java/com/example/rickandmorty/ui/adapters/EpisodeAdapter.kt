package com.example.rickandmorty.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemEpisodesBinding
import com.example.rickandmorty.models.EpisodeModel

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    private var list: List<EpisodeModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<EpisodeModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemEpisodesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(episodeModel: EpisodeModel) = with(binding) {
            tvEpisodeName.text = episodeModel.name
            tvEpisodeAirData.text = episodeModel.air_date
            tvEpisodeCode.text = episodeModel.episode
            tvEpisodeCreated.text = episodeModel.created
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemEpisodesBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(list[position])
    }
}