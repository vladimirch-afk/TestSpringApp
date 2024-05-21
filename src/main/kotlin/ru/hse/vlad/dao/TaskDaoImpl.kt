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
            Class.forName("org.postrgesql.Driver")
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/",
                user, password
            )
            if (connection != null) {
                println("Connection established")
            } else {
                println("Connection failed")
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }
    override fun getAll(): List<TaskEntity> {
        return listOf()
    }

    override fun addTask(task: TaskEntity) {

    }
}