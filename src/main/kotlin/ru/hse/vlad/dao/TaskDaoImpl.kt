package ru.hse.vlad.dao

import org.springframework.stereotype.Component
import ru.hse.vlad.entities.TaskEntity
import java.sql.Connection
import java.sql.DriverManager

@Component
class TaskDaoImpl : TaskDao {
    private final var connection : Connection? = null
    private final val user = "postgres"
    private final val password = "password"
    private final val databaseName = "postgres"
    val table = "tasks"
    init {
        try {
            Class.forName("org.postgresql.Driver")
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/${databaseName}",
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
            val statement = connection?.prepareStatement("SELECT * FROM $table")
            val result = statement?.executeQuery()
            while (result != null && result.next()) {
                val id = result.getInt("id")
                val title = result.getString("title")
                val desc = result.getString("description")
                res.add(TaskEntity(id, title, desc))
            }
        } catch (e: Exception) {
            throw Exception(e)
        }
        return res.toList()
    }

    override fun addTask(title : String, desc : String) : TaskEntity {
        try {
            val statement = connection?.prepareStatement(
                "INSERT INTO $table (title, description) VALUES('${title}', '${desc}')"
            )
            statement?.executeUpdate()
        } catch (e: Exception) {
            throw Exception(e.message)
        }
        return TaskEntity(getMaxId() + 1, title, desc)
    }

    override fun deleteTask(id: Int) {
        try {
            val statement = connection?.prepareStatement(
                "DELETE FROM $table WHERE id = $id"
            )
            statement?.executeUpdate()
        } catch (e: Exception) {
            throw Exception(e)
        }
    }

    override fun getMaxId(): Int {
        var maxId : Int? = -1
        try {
            val statement = connection?.prepareStatement(
                "SELECT MAX(id) FROM $table"
            )
            val res = statement?.executeQuery()
            res?.next()
            maxId = res?.getInt(1)
            statement?.close()
        } catch (_: Exception) { }
        return if (maxId == -1) 0 else maxId!!
    }
}