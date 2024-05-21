package ru.hse.vlad.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.hse.vlad.api.TaskController
import ru.hse.vlad.enities.TaskEntity
import ru.hse.vlad.services.TaskService

@RestController
class TaskControllerImpl(val taskService: TaskService) : TaskController {

    @GetMapping("/findAll")
    override fun findAll(): List<TaskEntity> {
        return taskService.getAll()
    }

    @GetMapping("/create")
    override fun createTask(@RequestParam desc: String, @RequestParam title: String): TaskEntity {
        return taskService.addTask(desc, title)
    }

    @GetMapping("/delete")
    override fun deleteTask(@RequestParam id: Int) {
        taskService.deleteTask(id)
    }
}