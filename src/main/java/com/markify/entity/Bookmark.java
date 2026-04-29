package com.markify.entity;
import jakarta.persistence.*;

@Entity
public class Bookmark{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;

    private String notes;

    protected Bookmark(){};

    public Bookmark(User user, Course course, String notes) {
        this.user = user;
        this.course = course;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Course getCourse() {
        return course;
    }

    public String getNotes() {
        return notes;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}