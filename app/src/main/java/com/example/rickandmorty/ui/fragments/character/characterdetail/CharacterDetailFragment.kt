package com.example.rickandmorty.ui.fragments.character.characterdetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.databinding.FragmentCharacterDetailBinding
import com.example.rickandmorty.ui.adapters.CharacterAdapter
import com.example.rickandmorty.ui.fragments.character.CharacterViewModel

class CharacterDetailFragment : BaseFragment<FragmentCharacterDetailBinding, CharacterViewModel>(R.layout.fragment_character_detail) {

        override val binding by viewBinding(FragmentCharacterDetailBinding::bind)
        override val viewModel: CharacterViewModel by viewModels()
        private val args by navArgs<CharacterDetailFragmentArgs>()

        override fun setupObserves() {
            viewModel.fetchCharacters(args.id).observe(viewLifecycleOwner) {
               binding.tvDetailCharacterName = it.
            }
        }
}