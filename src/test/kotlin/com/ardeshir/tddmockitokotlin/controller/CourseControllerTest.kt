package com.ardeshir.tddmockitokotlin.controller

import com.ardeshir.tddmockitokotlin.domain.Course
import com.ardeshir.tddmockitokotlin.service.CourseService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CourseControllerTest {

    val sampleList = listOf(Course(1, "firstCourse", "this is first", 1000),
            Course(2, "secondCourse", "this is second", 500))

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var courseService: CourseService


    @Test
    fun findAllCourseTest() {
        Mockito.`when`(courseService.getAllCourses()).thenReturn(sampleList)

        mockMvc.perform(get("/course"))
                .andExpect(status().`is`(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("firstCourse"))
    }

    @Test
    fun saveCourse() {
        Mockito.`when`(courseService.saveCourse(Course())).thenReturn(sampleList[0])
        val jsonCourse = """{}"""
        mockMvc.perform(post("/course")
                .content(jsonCourse).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().`is`(201))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("firstCourse"))
    }
}