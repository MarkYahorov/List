package com.example.list.data

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {

    val getAllLiveData: LiveData<List<Task>> = taskDao.getAllLiveData()

    fun  addTask(task: Task){
        taskDao.addTask(task)
    }

    fun updateTask(task: Task){
        taskDao.updateTask(task)
    }

    fun deleteTask(task: Task){
        taskDao.deleteTask(task)
    }

    fun deleteAllTasks(){
        taskDao.deleteAllTasks()
    }
}