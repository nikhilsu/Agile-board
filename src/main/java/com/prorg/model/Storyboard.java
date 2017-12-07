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
    @Size(max = 255, min = 3)
    private String title;

    @Column(name = "description")
    @Size(max = 1000, min=10)
    private String description;

    @Column(name = "created_by")
    @Size(min = 1)
    private String user_id;

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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}