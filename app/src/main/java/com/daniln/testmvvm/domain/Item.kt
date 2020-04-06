package com.daniln.testmvvm.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey
    @ColumnInfo(name = "text")
    val text: String
)