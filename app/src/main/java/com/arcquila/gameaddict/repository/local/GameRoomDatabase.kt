package com.arcquila.gameaddict.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.arcquila.gameaddict.repository.local.model.GameEntity

@Database(entities = [GameEntity::class], version = 2, exportSchema = false)
abstract class GameRoomDatabase: RoomDatabase() {
    abstract fun gameDao(): GameDao
}