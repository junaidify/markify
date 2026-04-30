package com.markify.service;

import com.markify.entity.Course;
import com.markify.entity.User;
import com.markify.repository.UserRepository;
import com.markify.repository.CourseRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public CourseService(CourseRepository courseRepository, UserRepository userRepository) {
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public String createCourse(String name, User authorId) {
        Optional<Course> existingCourse = courseRepository.findByNameAndAuthorId(name, authorId);

        if (existingCourse.isPresent()) {
            throw new RuntimeException("Course Already exist");
        }

        Course course = new Course(name, authorId);
        courseRepository.save(course);
        return "course created successfully.";
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Course doesn't exist"));
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Course> getCoursesByAuthor(Long authorId){
        User author = userRepository.findById(authorId).
                orElseThrow(() -> new RuntimeException("Author doesn't exist"));

        return courseRepository.findByAuthorId(author);
    }

    public String deleteById(Long id){
        Course isCourseExist = courseRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Course doesn't exist"));

        courseRepository.deleteById(isCourseExist.getId());
        return "Course deleted.";
    }

}
