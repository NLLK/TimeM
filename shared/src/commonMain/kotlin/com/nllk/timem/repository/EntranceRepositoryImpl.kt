package com.nllk.timem.repository

import com.nllk.timem.entity.EntranceEntity
import io.github.aakira.napier.Napier
import java.time.LocalDate

class EntranceRepositoryImpl : EntranceRepository {
    override fun create(entity: EntranceEntity) {
        Napier.i("create: {entity: $entity}")
        TODO("Not yet implemented")
    }

    override fun read(date: LocalDate): EntranceEntity? {
        Napier.i("read: {date: $date}")
        TODO("Not yet implemented")

        Napier.d("returns: ")
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
        Napier.i("update: {entity: $entity}")
        TODO("Not yet implemented")
    }

    override fun delete(entity: EntranceEntity) {
        TODO("Not yet implemented")
    }
}