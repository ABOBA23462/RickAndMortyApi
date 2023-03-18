package com.example.rickandmorty.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.databinding.ItemCharactersBinding
import com.example.rickandmorty.models.CharacterModel
import kotlin.reflect.KFunction1

class CharacterAdapter(val onItemClick: (id: Int) -> Unit) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private var list: List<CharacterModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CharacterModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick(list[adapterPosition].id)
            }
        }

        fun onBind(characterModel: CharacterModel) = with(binding) {
            tvCharacterName.text = characterModel.name
            tvCharacterStatus.text = characterModel.status
            tvCharacterSpecies.text = characterModel.species
            tvCharacterType.text = characterModel.type
            Glide.with(ivCharactersPicture.context).load(characterModel.image)
                .into(ivCharactersPicture)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharactersBinding.inflate(
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