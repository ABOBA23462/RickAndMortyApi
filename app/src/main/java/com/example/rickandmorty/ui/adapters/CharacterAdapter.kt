package com.example.rickandmorty.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.databinding.CharactersItemBinding
import com.example.rickandmorty.models.CharacterModel

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private var list: List<CharacterModel> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CharacterModel>){
        this.list = list
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: CharactersItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(characterModel: CharacterModel) {
            binding.tvCharacterName.text = characterModel.name
            Glide.with(binding.ivCharactersPicture.context).load(characterModel.image).into(binding.ivCharactersPicture)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CharactersItemBinding.inflate(
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