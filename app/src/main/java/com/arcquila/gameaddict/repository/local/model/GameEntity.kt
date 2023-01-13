package com.arcquila.gameaddict.repository.local.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class GameEntity (
    @PrimaryKey()
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "backgroundImage")
    val backgroundImage: String,

    @ColumnInfo(name = "released")
    val released: String,

    @ColumnInfo(name = "rating")
    val rating: String,

    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean
        ): Parcelable