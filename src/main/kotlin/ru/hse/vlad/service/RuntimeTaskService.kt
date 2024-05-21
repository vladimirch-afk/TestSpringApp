package ru.hse.vlad.services

import org.springframework.stereotype.Service
import ru.hse.vlad.dao.TaskDaoImpl
import ru.hse.vlad.enities.TaskEntity

@Service
class RuntimeTaskService : TaskService {
    val db = TaskDaoImpl()
    override fun getAll(): List<TaskEntity> {
        return db.getAll()
    }

    override fun addTask(desc: String, title: String) : TaskEntity {
        val newTask = TaskEntity(title, desc)
        db.addTask(newTask)
        return newTask
    }
}