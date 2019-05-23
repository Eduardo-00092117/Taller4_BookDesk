package com.example.taller4_bookdesk.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4_bookdesk.Entities.Author

import com.example.taller4_bookdesk.Entities.Book

@Dao
interface BookXAuthorDao {

    @Query("SELECT * FROM Author_table INNER JOIN book_x_tag ON author_table.id=AuthorxBook.authorID WHERE AuthorxBook.bookID=:authorID")
    fun selectAuthors(authorID:Int):List<Author>

    @Query("SELECT * FROM BOOK_TABLE INNER JOIN book_x_tag ON book_table.id=AuthorxBook.bookID WHERE AuthorxBook.bookID=:bookID")
    fun getBooks(bookID:Int):List<Book>
}