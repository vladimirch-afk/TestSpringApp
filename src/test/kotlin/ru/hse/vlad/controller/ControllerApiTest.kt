package ru.hse.vlad.controller

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.boot.test.context.SpringBootTest
import ru.hse.vlad.api.TaskController
import ru.hse.vlad.enities.TaskEntity
import ru.hse.vlad.services.RuntimeTaskService
import ru.hse.vlad.services.TaskService

@SpringBootTest
@ExtendWith(MockitoExtension::class)
class ControllerApiTest {
    @Mock
    val taskService : TaskService = RuntimeTaskService()

    @InjectMocks
    val taskApi : TaskController = TaskControllerImpl(taskService)

    @Test
    fun find__serviceApi() {
        Mockito.`when`(taskService.getAll()).thenReturn()
        val res = listOf(
            TaskEntity(1, "1", "1"),
            TaskEntity(2, "2", "2"),
            TaskEntity(3, "3", "3")
        )

        val ans1 = taskApi.createTask("1", "1")
        Assertions.assertEquals(ans1, taskApi.createTask("1", "1"))
        val ans2 = taskApi.createTask("2", "2")
        Assertions.assertEquals(ans2, taskApi.createTask("2", "2"))
        val ans3 = taskApi.createTask("3", "3")
        Assertions.assertEquals(ans3, taskApi.createTask("3", "3"))

        //Mockito.verify(taskService.)
        println("TEST_3 COMPLETED")
    }

    @Test
    fun delete__success() {
        val prev = service.getAll().toMutableList()
        val lastInd = prev.last().id
        prev.addAll(listOf(TaskEntity(lastInd + 1, "10", "11"),
            TaskEntity(lastInd + 2, "12", "13"),
            TaskEntity(lastInd + 3, "14", "15")))

        service.addTask("11", "10")
        service.addTask("13", "12")
        service.addTask("15", "14")
        var i = prev.size
        for (curr in prev) {
            service.deleteTask(curr.id)
            --i
            Assertions.assertEquals(true, service.getAll().size == i)
        }
        println("TEST_2 COMPLETED")
    }

    @Test
    fun find__success() {
        val prev = service.getAll().toMutableList()
        val lastInd = prev.last().id
        prev.addAll(listOf(TaskEntity(lastInd + 1, "10", "11"),
            TaskEntity(lastInd + 2, "12", "13"),
            TaskEntity(lastInd + 3, "14", "15")))

        service.addTask("11", "10")
        service.addTask("13", "12")
        service.addTask("15", "14")

        Assertions.assertEquals(prev, service.getAll())
        println("TEST_3 COMPLETED")
    }
}