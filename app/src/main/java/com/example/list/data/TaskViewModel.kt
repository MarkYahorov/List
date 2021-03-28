package com.example.list.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {

    val getAllData: LiveData<List<Task>>
    private val repository: TaskRepository

    init {
        val taskDao = TodoDataBase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
        getAllData = repository.getAllLiveData
    }

    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTask(task)
        }
    }

    fun updateTask(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateTask(task)
        }
    }

    fun deleteTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteTask(task)
        }
    }

    fun deleteAllTasks(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllTasks()
        }
    }

    //subTusk functions

    val getAllSubData: LiveData<List<SubTusk>>
    private val repositorySubTask: SubTaskRepository

    init {
        val subTaskDao = TodoDataBase.getDatabase(application).subTaskDao()
        repositorySubTask = SubTaskRepository(subTaskDao)
        getAllSubData = repositorySubTask.getAllSubTaskDao
    }

    fun addSubTask(subTask: SubTusk) {
        repositorySubTask.addSubTask(subTask)
    }

    fun updateSubTask(subTask: SubTusk) {
        repositorySubTask.updateSubTask(subTask)
    }

    fun deleteSubTask(subTask: SubTusk) {
        repositorySubTask.deleteSubTask(subTask)
    }


}