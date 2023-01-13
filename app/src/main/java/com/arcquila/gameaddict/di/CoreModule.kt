package com.arcquila.gameaddict.di

import com.arcquila.gameaddict.repository.GamesDataSource
import com.arcquila.gameaddict.repository.GamesRepository
import com.arcquila.gameaddict.repository.remote.ApiConfig
import com.arcquila.gameaddict.repository.remote.ApiService
import com.arcquila.gameaddict.ui.favorite.FavoriteViewModel
import com.arcquila.gameaddict.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.arcquila.gameaddict.utils.DatabaseService
import com.arcquila.gameaddict.utils.DatabaseService.provideDatabase
import com.arcquila.gameaddict.utils.DatabaseService.provideGame
import org.koin.android.ext.koin.androidApplication

val databaseModule = module {
    single{provideDatabase(androidApplication())}
    single { provideGame(get())}
}

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}

val favModule = module {
    viewModel {FavoriteViewModel(get())}
}

val networkModule = module {
    single<ApiService> { ApiConfig.getApiService() }
    single<GamesRepository>{GamesDataSource(get(),get())}
}