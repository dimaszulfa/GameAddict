package com.arcquila.gameaddict.repository.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.arcquila.gameaddict.repository.local.model.GameEntity
import retrofit2.http.DELETE

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(gameDao: GameEntity)

    @Update
    fun update(game: GameEntity)

    @Query("SELECT * FROM GameEntity")
    fun getAllGames(): List<GameEntity>

    @Delete
    fun delete(game: GameEntity)



}