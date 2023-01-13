package com.arcquila.gameaddict.utils

import android.app.Application
import androidx.room.Room
import com.arcquila.gameaddict.repository.local.GameDao
import com.arcquila.gameaddict.repository.local.GameRoomDatabase

object DatabaseService {
    fun provideDatabase(application: Application): GameRoomDatabase{
        return Room.databaseBuilder(application, GameRoomDatabase::class.java, "game")
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideGame(database: GameRoomDatabase): GameDao{
        return database.gameDao()
    }
}