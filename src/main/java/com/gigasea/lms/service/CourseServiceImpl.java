package com.gigasea.lms.service;

import com.gigasea.lms.model.Course;
import com.gigasea.lms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> findCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseId(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }
}
