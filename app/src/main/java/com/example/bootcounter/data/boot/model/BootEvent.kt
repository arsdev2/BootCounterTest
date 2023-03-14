package com.example.bootcounter.data.boot.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BootEvent(
    @PrimaryKey val id: Int,
    val timestamp: Long
)