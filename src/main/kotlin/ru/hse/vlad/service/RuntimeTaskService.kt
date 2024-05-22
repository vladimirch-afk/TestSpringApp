package ru.hse.vlad.service

import org.springframework.stereotype.Service
import ru.hse.vlad.dao.TaskDao
import ru.hse.vlad.entities.TaskEntity

@Service
class RuntimeTaskService(val db : TaskDao) : TaskService {

    override fun getAll(): List<TaskEntity> {
        val tasks = db.getAll()
        return tasks
    }

    override fun addTask(desc: String, title: String) : TaskEntity {
        return db.addTask(title, desc)
    }

    override fun deleteTask(id: Int) {
        db.deleteTask(id)
    }
}