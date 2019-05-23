package com.example.taller4_bookdesk.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4_bookdesk.Entities.Author

import com.example.taller4_bookdesk.Entities.Book
import com.example.taller4_bookdesk.Entities.Tag

@Dao
interface BookXAuthorDao {


    @Query("SELECT * FROM author_table INNER JOIN book_x_author ON book_x_author.author_id = author_table.id WHERE author_id=:AuthorID")
    fun selectAuthor(AuthorID: Int): LiveData<List<Author>>

    @Query("SELECT * FROM book_table INNER JOIN book_x_author ON book_x_author.book_id = book_table.id WHERE book_id=:BookID")
    fun selectBook(BookID: Int): LiveData<List<Book>>
}