package ru.hse.vlad.service

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import ru.hse.vlad.enities.TaskEntity
import ru.hse.vlad.services.RuntimeTaskService
import ru.hse.vlad.services.TaskService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import ru.hse.vlad.api.TaskController
import ru.hse.vlad.controller.TaskControllerImpl

@SpringBootTest
@ExtendWith(MockitoExtension::class)
class DemoApplicationTest {

	val service = RuntimeTaskService()

	@Test
	fun add__success() {
		val res1 = TaskEntity("1", "1")
		Assertions.assertEquals(res1, service.addTask("1", "1"))
		val res2 = TaskEntity("2", "2")
		Assertions.assertEquals(res2, service.addTask("2", "2"))
		val res3 = TaskEntity("3", "3")
		Assertions.assertEquals(res3, service.addTask("3", "3"))
		println("TEST_1 COMPLETED")
	}

	@Test
	fun find__success() {
		val res = listOf(TaskEntity("1", "1"),
		TaskEntity("2", "2"),
		TaskEntity("3", "3"))

		service.addTask("1", "1")
		service.addTask("2", "2")
		service.addTask("3", "3")

		Assertions.assertEquals(true, res == service.getAll())
		println("TEST_2 COMPLETED")
	}
}
