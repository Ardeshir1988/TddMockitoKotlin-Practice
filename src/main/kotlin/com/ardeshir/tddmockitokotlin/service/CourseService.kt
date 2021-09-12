package com.ardeshir.tddmockitokotlin.service

import com.ardeshir.tddmockitokotlin.domain.Course

interface CourseService {
    fun getAllCourses(): List<Course>
    fun saveCourse(course: Course): Course
}