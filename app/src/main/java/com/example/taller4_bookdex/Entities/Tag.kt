package com.example.taller4_bookdesk.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tag_table")
data class Tag(@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
               @ColumnInfo(name = "tag") val tag: String)