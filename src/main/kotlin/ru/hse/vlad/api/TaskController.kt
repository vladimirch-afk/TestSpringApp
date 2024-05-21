package ru.hse.vlad.api

import ru.hse.vlad.enities.TaskEntity

interface TaskController {
    fun findAll() : List<TaskEntity>
    fun createTask(desc: String, title: String) : TaskEntity
    fun deleteTask(id: Int)
}