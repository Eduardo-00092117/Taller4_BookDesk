package com.example.taller4_bookdesk.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "editorial_table")
data class Editorial(@PrimaryKey @ColumnInfo(name = "id") val id: Int,
                     @ColumnInfo(name = "name") val name: String)