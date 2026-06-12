package com.nllk.timem.entity

import java.time.LocalDate

data class EntranceEntity(
    var date: LocalDate,
    var type: Type
){
    enum class Type{
        ENTER,
        EXIT
    }
}