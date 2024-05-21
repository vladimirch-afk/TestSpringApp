package ru.hse.vlad.services

import ru.hse.vlad.enities.TaskEntity

interface TaskService {
    fun getAll() : List<TaskEntity>
    fun addTask(des: String, title: String) : TaskEntity
    fun deleteTask(id: Int)
}