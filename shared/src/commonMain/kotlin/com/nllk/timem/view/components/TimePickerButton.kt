package com.nllk.timem.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import java.time.LocalTime
import java.util.Calendar

@Suppress("DefaultLocale")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerButton(
    label: String,
    time: LocalTime,
    onTimeChanged: (LocalTime) -> Unit,
    modifier: Modifier = Modifier
)
{
    var showDialog by remember { mutableStateOf(false) }
    // Состояние пикера внутри диалога – инициализируем текущим выбранным временем
    val timePickerState = rememberTimePickerState(
        initialHour = time.hour,
        initialMinute = time.minute,
        is24Hour = true
    )

    Row(modifier = Modifier.clickable { showDialog = true }) {
        Text(text = label)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = String.format("%02d:%02d", time.hour, time.minute),
            color = MaterialTheme.colorScheme.secondary,
            textDecoration = TextDecoration.Underline  // подчёркивание
        )
    }

    // Диалог выбора времени
    if (showDialog) {
        TimePickerDialog(
            title = {"Время"},
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    onTimeChanged(LocalTime.of(timePickerState.hour, timePickerState.minute))
                    showDialog = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Отмена")
                }
            }
        ) {
            // Сам пикер
            TimePicker(state = timePickerState)
        }
    }
}