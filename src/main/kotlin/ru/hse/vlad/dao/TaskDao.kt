package ru.hse.vlad.dao

import ru.hse.vlad.enities.TaskEntity

interface TaskDao {
    fun getAll() : List<TaskEntity>
    fun addTask(task: TaskEntity)
}