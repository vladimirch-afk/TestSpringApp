package ru.hse.vlad.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import ru.hse.vlad.dao.TaskDao
import ru.hse.vlad.entities.TaskEntity

@ExtendWith(MockitoExtension::class)
class DemoApplicationTest {

	@Mock
	lateinit var taskDao : TaskDao

	@InjectMocks
	lateinit var service: RuntimeTaskService

	@Test
	fun add__success() {
		Mockito.`when`(taskDao.addTask("1", "2"))
			.thenReturn(TaskEntity(1, "1", "2"))
		Mockito.`when`(taskDao.addTask("2", "3"))
			.thenReturn(TaskEntity(2, "2", "3"))
		Mockito.`when`(taskDao.addTask("3", "4"))
			.thenReturn(TaskEntity(3, "3", "4"))

		val res1 = TaskEntity(1, "1", "2")
		Assertions.assertEquals(res1, service.addTask("2", "1"))
		val res2 = TaskEntity(2, "2", "3")
		Assertions.assertEquals(res2, service.addTask("3", "2"))
		val res3 = TaskEntity(3, "3", "4")
		Assertions.assertEquals(res3, service.addTask("4", "3"))

		Mockito.verify(taskDao, Mockito.times(1))
			.addTask("1", "2")
		Mockito.verify(taskDao, Mockito.times(1))
			.addTask("2", "3")
		Mockito.verify(taskDao, Mockito.times(1))
			.addTask("3", "4")
		println("TEST_1 COMPLETED")
	}

	@Test
	fun find__success() {
		Mockito.`when`(taskDao.getAll())
			.thenReturn(listOf(
				TaskEntity(1, "1", "2"),
				TaskEntity(2, "2", "3"),
				TaskEntity(3, "3", "4")
			))

		val res = service.getAll()
		val expected = listOf(
			TaskEntity(1, "1", "2"),
			TaskEntity(2, "2", "3"),
			TaskEntity(3, "3", "4")
		)

		Assertions.assertEquals(expected, res)
		Mockito.verify(taskDao, Mockito.times(1))
			.getAll()
		println("TEST_2 COMPLETED")
	}

	@Test
	fun delete__success() {

		service.deleteTask(1)
		service.deleteTask(2)
		service.deleteTask(3)

		Mockito.verify(taskDao, Mockito.times(1))
			.deleteTask(1)
		Mockito.verify(taskDao, Mockito.times(1))
			.deleteTask(2)
		Mockito.verify(taskDao, Mockito.times(1))
			.deleteTask(3)
		println("TEST_3 COMPLETED")
	}
}
