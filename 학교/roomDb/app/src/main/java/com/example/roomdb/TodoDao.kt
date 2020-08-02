package com.example.roomdb

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM Todo")
    fun getAll(): LiveData<List<Todo>>
    
    @Insert
    fun insertAll(todo : Todo)

    @Update
    fun updateAll(todo: Todo)

    @Delete
    fun delete(todo: Todo)
}