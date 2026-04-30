package com.markify.repository;

import com.markify.entity.Course;
import com.markify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByNameAndAuthorId(String name, User authorId);
    List<Course> findByAuthorId(User id);

}
