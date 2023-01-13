package com.arcquila.gameaddict.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.repository.GamesRepository
import com.arcquila.gameaddict.repository.local.model.GameEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: GamesRepository): ViewModel() {

    private var _games = MutableLiveData<List<Game>>()
    val games get() = _games

    private var _isFavorite = MutableLiveData<GameEntity>()
    val isFavorite get() = _isFavorite

    fun setFavorite(game: GameEntity){
        viewModelScope.run{
            launch(Dispatchers.IO){
                val getData = repository.addToFavorite(game)
                _isFavorite.postValue(game)
            }
        }
    }


    fun getGameData(){
        viewModelScope.run {
            launch(Dispatchers.IO){
                val getData = repository.getGames()
                _games.postValue(getData)
            }
        }
    }



}