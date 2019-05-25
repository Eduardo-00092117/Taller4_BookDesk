package com.example.taller4_bookdesk.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.taller4_bookdesk.Entities.Book
import com.example.taller4_bookdesk.Entities.Editorial

@Dao
interface EditorialDao {

    @Query("SELECT * from editorial_table ORDER BY id ASC")
    fun getAllWords(): LiveData<List<Editorial>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(edit: Editorial)

    @Query("DELETE FROM editorial_table")
    fun deleteAll()
}