package com.nllk.timem.view.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nllk.timem.view.components.TimePickerButton
import com.nllk.timem.viewModel.MainPageViewModel
import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(viewModel: MainPageViewModel = koinInject(), modifier: Modifier) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically){
                TimePickerButton("Время входа:")
                Spacer(modifier = Modifier.width(5.dp))
                Button(onClick = { viewModel.onEnterButtonClicked() }) {
                    Text("Вход")
                }
            }

            Row(verticalAlignment = Alignment.CenterVertically){
                TimePickerButton("Время выхода:")
                Spacer(modifier = Modifier.width(5.dp))
                Button(onClick = { viewModel.onExitButtonClicked() }) {
                    Text("Выход")
                }
            }

        }
    }
}