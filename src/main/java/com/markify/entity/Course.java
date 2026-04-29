package com.markify.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Course{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name="author_id")
    private User authorId;

    protected Course(){};

    public Course(String name, User authorId){
        this.name = name;
        this.authorId = authorId;
    }


    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public User getAuthorId() {
        return authorId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAuthorId(User authorId) {
        this.authorId = authorId;
    }
}