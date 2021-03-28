package com.example.list.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.list.data.Task

@Dao
interface TaskDao {

    @Insert()
    fun addTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun getAllLiveData(): LiveData<List<Task>>

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("DELETE FROM task_table")
    fun deleteAllTasks()
}