package com.nllk.timem.entity

import java.time.LocalDate
import java.time.LocalTime

data class EntranceEntity(
    val date: LocalDate, 
    var timeIn: LocalTime? = null,
    var timeOut: LocalTime? = null
)