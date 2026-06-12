package com.nllk.timem.application

import androidx.compose.runtime.Composable
import com.nllk.timem.view.MainView
import org.koin.compose.KoinApplication
import org.koin.dsl.koinConfiguration

@Composable
fun Application() {
    KoinApplication(configuration = koinConfiguration {
        modules(appModule)
    }) {
        MainView()
    }
}