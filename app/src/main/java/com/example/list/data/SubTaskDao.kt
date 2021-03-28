package com.example.list.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubTaskDao {

    @Insert()
    fun addSubTask(subTask: SubTusk)

    @Query("SELECT * FROM sub_tusk ORDER BY id ASC")
    fun getAllSubLiveData(): LiveData<List<SubTusk>>

    @Update
    fun updateSubTask(subTask: SubTusk)

    @Delete
    fun deleteSubTask(subTask: SubTusk)


}