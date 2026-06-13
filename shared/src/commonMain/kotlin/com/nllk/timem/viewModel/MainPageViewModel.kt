package com.nllk.timem.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.nllk.timem.entity.EntranceType
import com.nllk.timem.service.EntranceService
import io.github.aakira.napier.Napier
import java.time.LocalDate
import java.time.LocalTime

class MainPageViewModel(private val service: EntranceService) : ViewModel() {
    var entryTime: LocalTime by mutableStateOf(LocalTime.now())
        private set
    var exitTime: LocalTime by mutableStateOf(LocalTime.now())
        private set

    fun updateEntryTime(time: LocalTime) {
        Napier.v("Update entry time to $time")
        entryTime = time
    }

    fun updateExitTime(time: LocalTime) {
        Napier.v("Update exit time to $time")
        exitTime = time
    }

    fun onEnterButtonClicked() {
        Napier.i("Enter button clicked")
        service.addEntryRecord(LocalDate.now(), entryTime, EntranceType.ENTER)
    }

    fun onExitButtonClicked() {
        Napier.i("Exit button clicked")
        service.addEntryRecord(LocalDate.now(), entryTime, EntranceType.EXIT)
    }
}