package com.arcquila.gameaddict.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.arcquila.gameaddict.R
import com.arcquila.gameaddict.databinding.FragmentFavoriteBinding
import com.arcquila.gameaddict.databinding.FragmentHomeBinding
import com.arcquila.gameaddict.ui.home.HomeAdapter
import com.arcquila.gameaddict.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment : Fragment() {
    private lateinit var adapter: FavoriteAdapter
    private lateinit var _binding: FragmentFavoriteBinding
    private val vm: FavoriteViewModel by viewModel()
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FavoriteAdapter {
            vm.setFavorite(it)
        }

        binding.rvGames.adapter = adapter
        binding.rvGames.setHasFixedSize(true)
        binding.rvGames.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        vm.getFavoriteData()

        vm.games.observe(viewLifecycleOwner){
            adapter.addData(it)
            adapter.notifyDataSetChanged()
        }
    }


}