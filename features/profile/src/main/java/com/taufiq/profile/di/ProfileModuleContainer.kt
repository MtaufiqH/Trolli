package com.taufiq.profile.di

import com.taufiq.core.di.ModuleContainer
import com.taufiq.core.remote.NetworkProvider
import com.taufiq.profile.data.remote.ProfileWebService
import com.taufiq.profile.data.source.ProfileUserDataSource
import com.taufiq.profile.repository.ProfileRepository
import com.taufiq.profile.repository.ProfileRepositoryImpl
import org.koin.dsl.module

class ProfileModuleContainer : ModuleContainer() {

    private val webService = module {
        single<ProfileWebService> { NetworkProvider.createApi() }
    }

    private val dataSourceModule = module {
        single {
            ProfileUserDataSource(get())
        }
    }

    private val repositoryModule = module {
        single<ProfileRepository> {
            ProfileRepositoryImpl(get())
        }
    }
}