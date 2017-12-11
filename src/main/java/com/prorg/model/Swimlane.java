package com.prorg.model;

import javax.persistence.*;

@Entity
@Table(name = "swimlane")
public class Swimlane {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name="storyboard_id", nullable=false)
    private Storyboard storyboard;

    public int getId() {
        return id;
    }
    public Swimlane setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }
    public Swimlane setName(String name) {
        this.name = name;
        return this;
    }

    public Storyboard getStoryboard() {
        return storyboard;
    }

    public Swimlane setStoryboard(Storyboard storyboard) {
        this.storyboard = storyboard;
        return this;
    }
}
