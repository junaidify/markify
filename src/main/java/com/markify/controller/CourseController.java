package com.markify.controller;
import com.markify.entity.Course;
import com.markify.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }

    @GetMapping("/")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/authorId")
    public List<Course> getCoursesByAuthor(@PathVariable Long authorId){
        return courseService.getCoursesByAuthor(authorId);
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Long id){
        return courseService.deleteById(id);
    }

    @PostMapping("/{course}")
    public String createCourse(@RequestBody @Valid Course course){
        return courseService.createCourse(course.getName(), course.getAuthorId());
    }

}
