package com.arcquila.gameaddict.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arcquila.gameaddict.domain.Game
import com.arcquila.gameaddict.repository.GamesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: GamesRepository): ViewModel() {

    private var _games = MutableLiveData<List<Game>>()
    val games get() = _games

    fun getGameData(){
        viewModelScope.run {
            launch(Dispatchers.IO){
                val getData = repository.getGames()
                _games.postValue(getData)
            }
        }
    }

}