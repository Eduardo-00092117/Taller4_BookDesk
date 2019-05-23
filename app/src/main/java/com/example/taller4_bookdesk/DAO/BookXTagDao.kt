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
interface BookXTagDao {

    @Query("SELECT * FROM tag_table INNER JOIN book_x_tag ON book_x_tag.tag_id = tag_table.id WHERE tag_id=:tagID")
    fun selectTag(tagID: Int): LiveData<List<Tag>>

    @Query("SELECT * FROM author_table INNER JOIN book_x_tag ON book_x_tag.tag_id = author_table.id WHERE tag_id=:AuthorID")
    fun selectAuthors(AuthorID: Int): LiveData<List<Author>>
}