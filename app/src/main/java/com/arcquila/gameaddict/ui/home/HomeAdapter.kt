package com.arcquila.gameaddict.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arcquila.gameaddict.databinding.ItemGamesBinding
import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.ui.detail.DetailGameActivity
import com.bumptech.glide.Glide

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val gameList = ArrayList<Game>()
    var onItemClick: ((Game) -> Unit)? = null

    inner class ViewHolder(private val binding: ItemGamesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gameItem: Game) {
            binding.tvGameTitle.text = gameItem.name
            binding.tvRatingItem.text = gameItem.rating.toString()
            binding.tvReleaseDate.text = gameItem.released
            binding.itemGame.setOnClickListener {
                val moveToDetail = Intent(itemView.context, DetailGameActivity::class.java)
                moveToDetail.putExtra(DetailGameActivity.ID, gameItem.id)
                itemView.context.startActivity(moveToDetail)
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