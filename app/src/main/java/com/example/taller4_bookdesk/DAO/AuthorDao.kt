package com.example.taller4_bookdesk.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taller4_bookdesk.Entities.Author

@Dao
interface AuthorDao {

    @Query("SELECT * from author_table ORDER BY id ASC")
    fun getAllWords(): LiveData<List<Author>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(author: Author)

    @Query("DELETE FROM author_table")
    fun deleteAll()
}