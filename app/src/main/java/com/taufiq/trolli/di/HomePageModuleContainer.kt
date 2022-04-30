package com.taufiq.trolli.di

import com.taufiq.core.di.ModuleContainer
import com.taufiq.core.utils.customview.MainPageViewModel
import com.taufiq.trolli.home.HomePageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class HomePageModuleContainer : ModuleContainer() {

    private val viewModelModule = module {
        viewModel { HomePageViewModel(get()) }
        viewModel { MainPageViewModel() }
    }

}