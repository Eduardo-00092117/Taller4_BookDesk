package com.example.taller4_bookdesk.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4_bookdesk.Entities.Author

import com.example.taller4_bookdesk.Entities.Book
import com.example.taller4_bookdesk.Entities.BookXEditorial
import com.example.taller4_bookdesk.Entities.Editorial

@Dao
interface BookXEditorialDao {

    @Query("SELECT   * FROM editorial_table INNER JOIN book_x_edit ON book_x_edit.edit_id = editorial_table.id WHERE edit_id=:EditID")
    fun selectEdit(EditID: Int): LiveData<List<Editorial>>

    @Query("SELECT * FROM book_table INNER JOIN book_x_edit ON book_x_edit.book_id = book_table.id WHERE book_id=:BookID")
    fun selectBooks(BookID: Int): LiveData<List<Book>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(book: Book)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(BXE: BookXEditorial)

    @Query("DELETE FROM book_x_edit")
    fun deleteAll()
}