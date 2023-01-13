package com.arcquila.gameaddict.di

import com.arcquila.gameaddict.repository.GamesDataSource
import com.arcquila.gameaddict.repository.GamesRepository
import com.arcquila.gameaddict.repository.remote.ApiConfig
import com.arcquila.gameaddict.repository.remote.ApiService
import com.arcquila.gameaddict.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel(get()) }
}

val networkModule = module {
    single<ApiService> { ApiConfig.getApiService() }
    single<GamesRepository>{GamesDataSource(get())}
}