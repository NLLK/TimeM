package com.nllk.timem.service

import com.nllk.timem.entity.EntranceEntity
import com.nllk.timem.entity.EntranceType
import com.nllk.timem.repository.EntranceRepository
import java.time.LocalDate
import java.time.LocalTime

class EntranceService(private val repository: EntranceRepository) {
    fun addEntryRecord(date: LocalDate, time: LocalTime, type: EntranceType){
        var appearsInHistory = true

        var entity: EntranceEntity? = repository.read(date)
        if (entity == null){
            entity = EntranceEntity(date);
            appearsInHistory = false
        }

        when (type){
            EntranceType.ENTER -> entity.timeIn = time
            EntranceType.EXIT -> entity.timeOut = time
        }

        if (appearsInHistory){
            repository.update(entity)
        }else{
            repository.create(entity)
        }
    }
}