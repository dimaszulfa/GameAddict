package com.arcquila.gameaddict.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.arcquila.gameaddict.R
import com.arcquila.gameaddict.databinding.ItemGamesBinding
import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.repository.local.model.GameEntity
import com.arcquila.gameaddict.repository.remote.model.ResultsItem
import com.bumptech.glide.Glide

class HomeAdapter(val onFavorite: (GameEntity)->Unit): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val gameList = ArrayList<Game>()

    inner class ViewHolder(private val binding: ItemGamesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(gameItem: Game){
            binding.tvGameTitle.text = gameItem.name
            binding.tvRatingItem.text = gameItem.rating.toString()
            binding.tvReleaseDate.text = gameItem.released
            binding.itemGame.setOnClickListener{
                onFavorite(gameItem.toGameEntity())
                Toast.makeText(it.context, "Item ${gameItem.name} di Klik", Toast.LENGTH_SHORT).show()
            }
            Glide.with(itemView).load(gameItem.backgroundImage).into(binding.ivGameImage)
        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemGamesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = gameList[position]
        holder.bind(game)
    }

    override fun getItemCount(): Int = gameList.size

    fun addData(data: List<Game>) {
        gameList.clear()
        gameList.addAll(data)
        notifyDataSetChanged()
    }
}