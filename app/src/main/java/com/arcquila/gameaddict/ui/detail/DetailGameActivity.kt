package com.arcquila.gameaddict.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.arcquila.gameaddict.R
import com.arcquila.gameaddict.databinding.ActivityDetailGameBinding
import com.arcquila.gameaddict.domain.DetailGame
import com.arcquila.gameaddict.repository.local.model.GameEntity
import com.arcquila.gameaddict.ui.home.HomeViewModel
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailGameActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityDetailGameBinding
    private val binding get() = _binding
    private val vm: HomeViewModel by viewModel()

    companion object{
        var ID = "ID"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailGameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val extra = intent.extras
        val id = extra?.getString(ID)
        vm.detailGame(id.toString())
        vm.detailGame.observe(this@DetailGameActivity){ it ->
            it.map {
                init(it)
                binding.tvName.text = it.name
                binding.tvPlaytime.text = it.playtime
                binding.tvRating.text = it.rating
                Glide.with(this@DetailGameActivity).load(it.backgroundImage).into(binding.ivGameImageDetail)
                binding.tvDesc.text = it.description
                binding.tvPublisher.text = it.publisher
                binding.fabFav.setOnClickListener{click ->
                    if(!it.isFavorite){
                        binding.fabFav.setImageResource(R.drawable.ic_baseline_favorite_24)
                        Toast.makeText(this@DetailGameActivity,"to Favorite",Toast.LENGTH_SHORT).show()
                    } else {
                        binding.fabFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                        Toast.makeText(this@DetailGameActivity,"unfavorite",Toast.LENGTH_SHORT).show()
                    }
                    it.isFavorite = !it.isFavorite
                    vm.addFavorite(it)
                }
            }
        }

    }

    fun init(game: DetailGame){
        if(game.isFavorite){
            binding.fabFav.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.fabFav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }
}