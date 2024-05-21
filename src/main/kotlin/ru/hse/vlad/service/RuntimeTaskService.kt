package ru.hse.vlad.services

import org.springframework.stereotype.Service
import ru.hse.vlad.dao.TaskDaoImpl
import ru.hse.vlad.enities.TaskEntity

@Service
class RuntimeTaskService : TaskService {
    val db = TaskDaoImpl()
    override fun getAll(): List<TaskEntity> {
        val tasks = db.getAll()
        return tasks
    }

    override fun addTask(desc: String, title: String) : TaskEntity {
        val newTask = TaskEntity(db.getMaxId() + 1, title, desc)
        db.addTask(newTask)
        return newTask
    }

    override fun deleteTask(id: Int) {
        db.deleteTask(id)
    }
}