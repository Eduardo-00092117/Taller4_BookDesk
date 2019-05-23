package com.example.taller4_bookdesk.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.taller4_bookdesk.Entities.Book

@Dao
interface BookXEditorialDao {

    @Query("SELECT * from book_table ORDER BY id ASC")
    fun getAllWords(): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    @Query("DELETE FROM book_table")
    fun deleteAll()
}