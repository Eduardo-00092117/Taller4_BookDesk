package com.example.taller4_bookdesk.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "book_x_edit",
    primaryKeys = ["edit_id", "book_id"])
data class BookXEditorial(
    @ForeignKey(
        entity = Editorial::class,
        parentColumns = ["id"],
        childColumns = ["edit_id"]
    )
    @ColumnInfo(name = "id") val edit_id: Int,

    @ForeignKey(
        entity = Book::class,
        parentColumns = ["id"],
        childColumns = ["book_id"]
    )
    @ColumnInfo(name = "id") val book_id: Int
)