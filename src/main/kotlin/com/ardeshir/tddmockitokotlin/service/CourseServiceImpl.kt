package com.ardeshir.tddmockitokotlin.service

import com.ardeshir.tddmockitokotlin.domain.Course
import com.ardeshir.tddmockitokotlin.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseServiceImpl(val courseRepository: CourseRepository) : CourseService {
    override fun getAllCourses(): List<Course> = courseRepository.findAll()
}