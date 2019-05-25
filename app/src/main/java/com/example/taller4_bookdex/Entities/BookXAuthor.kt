package com.example.taller4_bookdesk.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "book_x_author",
    primaryKeys = ["author_id", "book_id"])
data class BookXEditorial(
    @ForeignKey(
        entity = Author::class,
        parentColumns = ["id"],
        childColumns = ["author_id"]
    )
    @ColumnInfo(name = "author_id") val author_id: Int,

    @ForeignKey(
        entity = Book::class,
        parentColumns = ["id"],
        childColumns = ["book_id"]
    )
    @ColumnInfo(name = "book_id") val book_id: Int
)