package com.arcquila.gameaddict.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.arcquila.gameaddict.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private lateinit var adapter: HomeAdapter
    private lateinit var _binding: FragmentHomeBinding
    private val vm: HomeViewModel by viewModel()
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HomeAdapter()
        binding.rvGames.adapter = adapter
        binding.rvGames.setHasFixedSize(true)
        binding.rvGames.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        vm.getGameData()

        binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {

                return false

            }

            override fun onQueryTextChange(msg: String): Boolean {
                // inside on query text change method we are
                // calling a method to filter our recycler view.
/*                vm.searchGame(msg)
                vm.searchGame.observe(viewLifecycleOwner) {
                    adapter.addData(it)
                    adapter.notifyDataSetChanged()
                }*/
                return false
            }
        })


        vm.games.observe(viewLifecycleOwner) {
            adapter.addData(it)
            adapter.notifyDataSetChanged()
        }
    }

}