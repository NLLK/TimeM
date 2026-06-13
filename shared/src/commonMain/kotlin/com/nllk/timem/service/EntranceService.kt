package com.nllk.timem.service

import com.nllk.timem.entity.EntranceEntity
import com.nllk.timem.entity.EntranceType
import com.nllk.timem.repository.EntranceRepository
import io.github.aakira.napier.Napier
import java.time.LocalDate
import java.time.LocalTime

class EntranceService(private val repository: EntranceRepository) {
    fun addEntryRecord(date: LocalDate, time: LocalTime, type: EntranceType){
        Napier.i("Add entry: { date: $date, time: $time, type: $type}")
        var appearsInHistory = true

        var entity: EntranceEntity? = repository.read(date)
        if (entity == null){
            Napier.d("No entry of this date found: {date: $date}")
            entity = EntranceEntity(date);
            appearsInHistory = false
        }

        when (type){
            EntranceType.ENTER -> entity.timeIn = time
            EntranceType.EXIT -> entity.timeOut = time
        }

        if (appearsInHistory){
            Napier.d("Update entity: {entity: $entity}")
            repository.update(entity)
        }else{
            Napier.d("Create entity: {entity: $entity}")
            repository.create(entity)
        }
    }
}