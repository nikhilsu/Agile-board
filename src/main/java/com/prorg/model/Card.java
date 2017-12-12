package com.prorg.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    @Min(1)
    @Max(255)
    private String title;

    @Column
    @Max(1023)
    private String description;

    @ManyToOne
    @JoinColumn(name = "swimlane_id", nullable = false)
    private Swimlane swimlane;

    @ManyToMany(mappedBy = "cards")
    @LazyCollection(value = LazyCollectionOption.FALSE)
    private List<User> assignedUser;

    public int getId() {
        return id;
    }
    public Card setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }
    public Card setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }
    public Card setDescription(String description) {
        this.description = description;
        return this;
    }

    public Swimlane getSwimlane() {
        return swimlane;
    }
    public Card setSwimlane(Swimlane swimlane) {
        this.swimlane = swimlane;
        return this;
    }

    public List<User> getAssignedUser() {
        return assignedUser;
    }
    public Card setAssignedUser(List<User> assignedUser) {
        this.assignedUser = assignedUser;
        return this;
    }
}
