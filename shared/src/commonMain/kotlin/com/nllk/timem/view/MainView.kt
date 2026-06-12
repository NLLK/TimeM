package com.nllk.timem.view

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nllk.timem.view.pages.HomePage
import com.nllk.timem.viewModel.MainPageViewModel
import org.koin.compose.koinInject

@Composable
fun AppBottomNavigation(
    currentScreen: Screen,
    onScreenSelected: (Screen) -> Unit
) {
    // Список всех экранов, которые будут отображаться в панели
    val screens = listOf(Screen.Home, Screen.Profile, Screen.Settings)

    NavigationBar {
        screens.forEach { screen ->
            NavigationBarItem(
                selected = currentScreen == screen,
                onClick = { onScreenSelected(screen) },
                icon = { Icon(screen.icon, contentDescription = screen.title) },
                label = { Text(screen.title) }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MainView() {
    // Состояние для хранения текущего выбранного экрана
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    // Scaffold обеспечивает правильную структуру экрана
    Scaffold(
        bottomBar = {
            // Здесь будет наша панель навигации
            AppBottomNavigation(
                currentScreen = currentScreen,
                onScreenSelected = { screen -> currentScreen = screen }
            )
        }
    ) { paddingValues ->
        // Здесь отображаем контент для выбранного экрана
        when (currentScreen) {
            Screen.Home -> HomePage(modifier = Modifier.padding(paddingValues))

//            Screen.Settings -> SettingsScreen(modifier = Modifier.padding(paddingValues))
            else -> {}
        }
    }
}