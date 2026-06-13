package com.nllk.timem.repository

import com.nllk.timem.entity.EntranceEntity
import java.time.LocalDate

class EntranceRepositoryImpl : EntranceRepository {
    override fun create(entity: EntranceEntity) {
        TODO("Not yet implemented")
    }

    override fun read(date: LocalDate): EntranceEntity? {
        TODO("Not yet implemented")
    }

    override fun readLast(number: Int): List<EntranceEntity> {
        TODO("Not yet implemented")
    }

    override fun readFromDateToDate(
        dateFrom: LocalDate,
        dateTo: LocalDate
    ): List<EntranceEntity> {
        TODO("Not yet implemented")
    }

    override fun update(entity: EntranceEntity) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: EntranceEntity) {
        TODO("Not yet implemented")
    }
}