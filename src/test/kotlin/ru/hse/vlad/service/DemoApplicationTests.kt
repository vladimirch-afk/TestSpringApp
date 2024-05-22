package ru.hse.vlad.service

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import ru.hse.vlad.enities.TaskEntity
import ru.hse.vlad.services.RuntimeTaskService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@SpringBootTest
@ExtendWith(MockitoExtension::class)
class DemoApplicationTest {

	val service = RuntimeTaskService()

	@Test
	fun add__success() {
		val res1 = TaskEntity(1, "1", "1")
		Assertions.assertEquals(res1, service.addTask("1", "1"))
		val res2 = TaskEntity(2, "2", "2")
		Assertions.assertEquals(res2, service.addTask("2", "2"))
		val res3 = TaskEntity(3, "3", "3")
		Assertions.assertEquals(res3, service.addTask("3", "3"))
		println("TEST_1 COMPLETED")
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
