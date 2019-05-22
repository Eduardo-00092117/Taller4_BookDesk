package com.example.taller4_bookdesk.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book(@PrimaryKey @ColumnInfo(name = "id") val id: Int,
                @ColumnInfo(name = "Titulo") val titulo: String,
                @ColumnInfo(name = "ISBN") val isbn: String,
                @ColumnInfo(name = "Resumen") val resumen: String,
                @ColumnInfo(name = "Edicion") val edicion: String,
                @ColumnInfo(name = "Favorito") val isFavorite: Int
              )