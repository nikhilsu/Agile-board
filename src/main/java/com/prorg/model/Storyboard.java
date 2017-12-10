package com.prorg.model;
import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "storyboard_details")
public class Storyboard {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    @Size(max = 255, min = 1)
    private String title;

    @Column(name = "description")
    @Size(max = 1000)
    private String description;

    @Column(name = "created_by")
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}