package com.prorg.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_details")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstname")
    @Size(max = 255, min = 3)
    private String firstName;

    @Column(name = "lastname")
    @Size(max = 255, min = 1)
    private String lastName;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}