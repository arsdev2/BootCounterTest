package com.example.bootcounter.data.boot.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bootcounter.data.boot.model.BootEvent
import kotlinx.coroutines.flow.Flow

@Dao
interface BootEventDao {

    @Insert
    suspend fun addBootEvent(bootEvent: BootEvent)

    @Query("SELECT * FROM boots")
    suspend fun getBootEventListOnce(): List<BootEvent>

    fun getBootEventList(): Flow<List<BootEvent>>

}