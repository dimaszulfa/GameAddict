package com.arcquila.gameaddict.ui.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.repository.GamesRepository
import com.arcquila.gameaddict.repository.local.model.GameEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoriteViewModel(private val repository: GamesRepository): ViewModel() {

    private var _games = MutableLiveData<List<GameEntity>>()
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


    fun getFavoriteData(){
        viewModelScope.run {
            launch(Dispatchers.IO){
                val getData = repository.getFavoriteGames()
                _games.postValue(getData)
            }
        }
    }

}