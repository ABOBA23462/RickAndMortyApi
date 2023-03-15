package com.example.rickandmorty.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.LocationsItemBinding
import com.example.rickandmorty.models.LocationsModel

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    private var list: List<LocationsModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<LocationsModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: LocationsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(locationsModel: LocationsModel) = with(binding) {
            tvLocationName.text = locationsModel.name
            tvLocationType.text = locationsModel.type
            tvLocationDimension.text = locationsModel.dimension
            tvLocationCreated.text = locationsModel.created
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LocationsItemBinding.inflate(
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