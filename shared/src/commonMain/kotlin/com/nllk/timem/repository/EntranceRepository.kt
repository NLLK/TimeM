package com.nllk.timem.repository

import com.nllk.timem.entity.EntranceEntity
import java.time.LocalDate

interface EntranceRepository {
    fun create(entity: EntranceEntity)
    fun read(id: Int) : EntranceEntity
    fun readLast(number: Int) : List<EntranceEntity>
    fun readFromDateToDate(dateFrom: LocalDate, dateTo: LocalDate) : List<EntranceEntity>
    fun update(entity: EntranceEntity)
    fun delete(entity: EntranceEntity)
}