package com.example.rickandmorty.ui.fragments.episode

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentEpisodeBinding
import com.example.rickandmorty.ui.adapters.EpisodeAdapter

class EpisodeFragment :
    BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(R.layout.fragment_episode) {

    override val binding by viewBinding(FragmentEpisodeBinding::bind)
    override val viewModel: EpisodeViewModel by viewModels()
    private var episodeAdapter = EpisodeAdapter(this::onItemClick)

    override fun initialize() {
        binding.rvEpisode.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = episodeAdapter
        }
//        binding.btn.setOnClickListener {
//            binding.rvCharacters.scrollToPosition(characterAdapter.itemCount - 1)
//        }
    }

    override fun setupObserves() {
        viewModel.fetchEpisode().observe(viewLifecycleOwner) {
            episodeAdapter.setList(it.results)
        }
    }

    private fun onItemClick(id: Int){
        findNavController().navigate(EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(id))
    }
}