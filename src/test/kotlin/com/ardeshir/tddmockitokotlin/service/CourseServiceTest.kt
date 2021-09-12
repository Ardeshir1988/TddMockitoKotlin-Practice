package com.ardeshir.tddmockitokotlin.service

import com.ardeshir.tddmockitokotlin.domain.Course
import com.ardeshir.tddmockitokotlin.repository.CourseRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean

@SpringBootTest
class CourseServiceTest {

    val sampleList = listOf(Course(1, "firstCourse", "this is first", 1000),
            Course(2, "secondCourse", "this is second", 500))

    @MockBean
    private lateinit var courseRepository: CourseRepository

    @Autowired
    private lateinit var courseService: CourseService

    @Test
    fun testCourseService() {
        Mockito.`when`(courseRepository.findAll()).thenReturn(sampleList)
        val courseList: List<Course> = courseService.getAllCourses();
        Assertions.assertEquals(sampleList, courseList)
    }
}