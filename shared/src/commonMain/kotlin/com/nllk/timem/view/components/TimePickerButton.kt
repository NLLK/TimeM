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
import java.util.Calendar

@Suppress("DefaultLocale")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerButton(
    label: String,
    initialHour: Int = Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
    initialMinute: Int = Calendar.getInstance().get(Calendar.MINUTE),
    onTimeChanged: ((hour: Int, minute: Int) -> Unit)? = null)
{
    var hour by remember { mutableIntStateOf(initialHour) }
    var minute by remember { mutableIntStateOf(initialMinute) }
    var showDialog by remember { mutableStateOf(false) }
    // Состояние пикера внутри диалога – инициализируем текущим выбранным временем
    val timePickerState = rememberTimePickerState(
        initialHour = hour,
        initialMinute = minute,
        is24Hour = true
    )

    Row(modifier = Modifier.clickable { showDialog = true }) {
        Text(text = label)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = String.format("%02d:%02d", hour, minute),
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
                    // Подтверждение – сохраняем время из пикера
                    hour = timePickerState.hour
                    minute = timePickerState.minute
                    onTimeChanged?.invoke(hour, minute)
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