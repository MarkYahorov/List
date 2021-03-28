package com.example.list.data


class SubTaskRepository(private val subTaskDao: SubTaskDao) {

    val getAllSubTaskDao = subTaskDao.getAllSubLiveData()

    fun addSubTask(subTask: SubTusk) {
        subTaskDao.addSubTask(subTask)
    }

    fun updateSubTask(subTask: SubTusk) {
        subTaskDao.updateSubTask(subTask)
    }

    fun deleteSubTask(subTask: SubTusk) {
        subTaskDao.deleteSubTask(subTask)
    }
}