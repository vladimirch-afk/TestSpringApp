package ru.hse.vlad.dao

import ru.hse.vlad.enities.TaskEntity
import java.sql.Connection
import java.sql.DriverManager


class TaskDaoImpl : TaskDao {
    val db : MutableList<TaskEntity> = mutableListOf()
    var connection : Connection? = null
    init {
        try {
            val user = "postgres"
            val password = "password"
            val table = "tasks"
            Class.forName("org.postgresql.Driver")
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                user, password
            )
            if (connection == null) {
                throw Exception("Connection failed")

            }
        } catch (e: Exception) {
            throw Exception("Connection failed")
        }
    }
    override fun getAll(): List<TaskEntity> {
        val res = mutableListOf<TaskEntity>()
        try {
            val statement = connection?.prepareStatement("SELECT * FROM tasks")
            val result = statement?.executeQuery()
            while (result != null && result.next()) {
                val title = result.getString("title")
                val desc = result.getString("description")
                res.add(TaskEntity(title, desc))
            }
        } catch (e: Exception) {
            throw Exception(e)
        }
        return res.toList()
    }

    override fun addTask(task: TaskEntity) {
        try {
            val statement = connection?.prepareStatement("SELECT * FROM tasks")
            val result = statement?.executeQuery()
            while (result != null && result.next()) {
                val title = result.getString("title")
                val desc = result.getString("description")
                res.add(TaskEntity(title, desc))
            }
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
}