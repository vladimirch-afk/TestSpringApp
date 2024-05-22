package ru.hse.vlad.service

import ru.hse.vlad.entities.TaskEntity

interface TaskService {
    fun getAll() : List<TaskEntity>
    fun addTask(des: String, title: String) : TaskEntity
    fun deleteTask(id: Int)
}