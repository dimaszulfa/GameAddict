package com.arcquila.gameaddict.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arcquila.gameaddict.domain.DetailGame
import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.repository.GamesRepository
import com.arcquila.gameaddict.repository.local.model.GameEntity
import com.arcquila.gameaddict.repository.remote.model.GamesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: GamesRepository): ViewModel() {

    private var _games = MutableLiveData<List<Game>>()
    val games get() = _games

    private var _isFavorite = MutableLiveData<DetailGame>()

    private var _detailGame = MutableLiveData<List<DetailGame>>()
    val detailGame get() = _detailGame

    private var _searchGame = MutableLiveData<List<Game>>()
    val searchGame get() = _searchGame

    fun addFavorite(game: DetailGame){
        viewModelScope.run{
            launch(Dispatchers.IO){
                val getData = if(!game.isFavorite){
                    repository.addToFavorite(game.toGameEntity())
                } else {
                    repository.deleteFav(game.toGameEntity())
                }
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

    fun detailGame(id: String){
        viewModelScope.launch(Dispatchers.IO){
            val getData = repository.getDetailGames(id)
            _detailGame.postValue(getData)
        }
    }

    fun searchGame(query: String){
        viewModelScope.launch(Dispatchers.IO){
            val getData = repository.searchGame(query)
            _searchGame.postValue(getData)
        }
    }


}