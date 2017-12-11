package com.prorg.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "swimlane")
public class Swimlane {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @NotNull
    @Max(255)
    private String name;

    @ManyToOne
    @JoinColumn(name="storyboard_id", nullable=false)
    private Storyboard storyboard;

    @OneToMany(mappedBy = "swimlane")
    private List<Card> cards;

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

    public List<Card> getCards() {
        return cards;
    }
    public Swimlane setCards(List<Card> cards) {
        this.cards = cards;
        return this;
    }
}
