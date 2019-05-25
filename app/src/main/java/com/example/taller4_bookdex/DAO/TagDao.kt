package com.example.taller4_bookdesk.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.taller4_bookdesk.Entities.Tag

@Dao
interface TagDao {

    @Query("SELECT * from tag_table ORDER BY id ASC")
    fun getAllWords(): LiveData<List<Tag>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(tag: Tag)

    @Query("DELETE FROM tag_table")
    fun deleteAll()
}