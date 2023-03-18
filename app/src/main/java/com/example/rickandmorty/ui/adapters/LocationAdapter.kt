package com.example.rickandmorty.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemLocationsBinding
import com.example.rickandmorty.models.LocationsModel

class LocationAdapter(val onItemClick: (id: Int) -> Unit) : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    private var list: List<LocationsModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<LocationsModel>) {
        this.list = list
        notifyDataSetChanged()
    }

  inner  class ViewHolder(private val binding: ItemLocationsBinding) :
        RecyclerView.ViewHolder(binding.root) {

      init {
          itemView.setOnClickListener {
              onItemClick(list[adapterPosition].id)
          }
      }

        fun onBind(locationsModel: LocationsModel) = with(binding) {
            tvLocationName.text = locationsModel.name
            tvLocationType.text = locationsModel.type
            tvLocationDimension.text = locationsModel.dimension
            tvLocationCreated.text = locationsModel.created
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLocationsBinding.inflate(
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