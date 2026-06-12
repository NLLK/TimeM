package com.nllk.timem.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Factory
import androidx.compose.material.icons.filled.Timer
import androidx.compose.ui.graphics.vector.ImageVector

// 1. Определяем все возможные экраны
sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Главная", Icons.Default.Factory)
    object Profile : Screen("history", "Профиль", Icons.Default.Timer)
    object Settings : Screen("calc", "Калькулятор", Icons.Default.Calculate)
}