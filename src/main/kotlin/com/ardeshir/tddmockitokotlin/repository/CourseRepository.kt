package com.ardeshir.tddmockitokotlin.repository

import com.ardeshir.tddmockitokotlin.domain.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseRepository: JpaRepository<Course,Int> {
}