package com.nllk.timem.application

import com.nllk.timem.repository.EntranceRepository
import com.nllk.timem.repository.EntranceRepositoryImpl
import com.nllk.timem.service.EntranceService
import com.nllk.timem.viewModel.MainPageViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::EntranceRepositoryImpl){bind<EntranceRepository>()}
    single { EntranceService() }
    factory { MainPageViewModel(get()) }
}