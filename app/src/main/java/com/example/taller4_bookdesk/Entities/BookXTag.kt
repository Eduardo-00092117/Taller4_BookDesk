package com.example.taller4_bookdesk.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "book_x_tag",
    primaryKeys = ["tag_id", "book_id"])
data class BookXTag(
    @ForeignKey(
        entity = Tag::class,
        parentColumns = ["id"],
        childColumns = ["tag_id"]
    )
    @ColumnInfo(name = "id") val tag_id: Int,

    @ForeignKey(
        entity = Book::class,
        parentColumns = ["id"],
        childColumns = ["book_id"]
    )
    @ColumnInfo(name = "id") val book_id: Int
)