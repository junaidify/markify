package com.markify.service;

import com.markify.entity.Course;
import com.markify.entity.User;
import com.markify.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(String name, User authorId) {
        Optional<Course> existingCourse = courseRepository.findByNameAndAuthorId(name, authorId);

        if (existingCourse.isPresent()) {
            throw new RuntimeException("Course Already exist");
        }

        Course course = new Course(name, authorId);
        return courseRepository.save(course);
    }

    public Course getByName(String name) {
        return courseRepository.findByName(name);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getById(User authorId) {
        return courseRepository.findByAuthorId(authorId);
    }
}
