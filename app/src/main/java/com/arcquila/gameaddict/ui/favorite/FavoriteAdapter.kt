package com.arcquila.gameaddict.ui.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.arcquila.gameaddict.databinding.ItemGamesBinding
import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.repository.local.model.GameEntity
import com.bumptech.glide.Glide

class FavoriteAdapter(val onFavorite: (GameEntity)->Unit): RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    private val list = ArrayList<GameEntity>()

     inner class ViewHolder(private val binding: ItemGamesBinding): RecyclerView.ViewHolder(binding.root) {
         fun bind(gameItem: GameEntity){
             binding.tvGameTitle.text = gameItem.name
             binding.tvRatingItem.text = gameItem.rating.toString()
             binding.tvReleaseDate.text = gameItem.released
//             binding.itemGame.setOnClickListener{
//                 Toast.makeText(it.context, "Item ${gameItem.name} di Klik", Toast.LENGTH_SHORT).show()
//             }
             Glide.with(itemView).load(gameItem.backgroundImage).into(binding.ivGameImage)
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemGamesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game = list[position]
        holder.bind(game)
    }

    override fun getItemCount(): Int = list.size

    fun addData(data: List<GameEntity>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }
}