package ru.hse.vlad.dao

import ru.hse.vlad.entities.TaskEntity

interface TaskDao {
    fun getAll() : List<TaskEntity>
    fun addTask(title: String, desc: String) : TaskEntity
    fun deleteTask(id: Int)
    fun getMaxId() : Int
}