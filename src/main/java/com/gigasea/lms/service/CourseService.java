package com.gigasea.lms.service;

import com.gigasea.lms.model.Course;

import java.util.List;

public interface CourseService {
    void saveCourse(Course course);
    List<Course> findCourse();
    Course getCourseId(Long id);
    void deleteCourse(Long id);
    void deleteAllCourses();
}
