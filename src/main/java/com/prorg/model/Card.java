package com.prorg.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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

    // TODO: AssignedUsers

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
}
