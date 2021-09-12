package com.ardeshir.tddmockitokotlin.controller

import com.ardeshir.tddmockitokotlin.domain.Course
import com.ardeshir.tddmockitokotlin.service.CourseService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/course")
class CourseController(val courseService: CourseService) {
    @GetMapping
    fun getAllCourse(): List<Course> = courseService.getAllCourses()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCourse(@RequestBody course: Course): Course = courseService.saveCourse(course)
}