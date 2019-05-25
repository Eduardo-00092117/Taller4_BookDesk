package com.example.taller4_bookdesk.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4_bookdesk.Entities.*

@Dao
interface BookXTagDao {

    @Query("SELECT * FROM tag_table INNER JOIN book_x_tag ON book_x_tag.tag_id = tag_table.id WHERE tag_id=:tagID")
    fun selectTag(tagID: Int): LiveData<List<Tag>>

    @Query("SELECT * FROM book_table INNER JOIN book_x_tag ON book_x_tag.book_id = book_table.id WHERE book_id=:BookID")
    fun selectBooks(BookID: Int): LiveData<List<Book>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(BXT: BookXTag)

    @Query("DELETE FROM book_x_tag")
    fun deleteAll()
}