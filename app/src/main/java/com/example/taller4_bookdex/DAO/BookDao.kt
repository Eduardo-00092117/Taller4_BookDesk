package com.example.taller4_bookdesk.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.taller4_bookdesk.Entities.Book

@Dao
interface BookDao {

    @Query("SELECT * from book_table ORDER BY id ASC")
    fun getAllBooks(): LiveData<List<Book>>

    @Query("SELECT * from book_table WHERE book_table.Favorito=1 ORDER BY id ASC")
    fun getfavBooks(): LiveData<List<Book>>

    @Query("UPDATE book_table set Favorito=1 WHERE id=:IdBook")
    fun makefavBooks(IdBook: Int): LiveData<List<Book>>

    @Query("UPDATE book_table set Favorito=0 WHERE id=:IdBook")
    fun unfavBooks(IdBook: Int): LiveData<List<Book>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    @Query("DELETE FROM book_table")
    fun deleteAll()
}