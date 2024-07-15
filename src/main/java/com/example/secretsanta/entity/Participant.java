package com.example.secretsanta.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;

@Entity
@Table(name = "Participants")
@Getter
@EqualsAndHashCode
public class Participant {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(mappedBy = "participants")
    private ArrayList<Group> groups;

    public Participant() {
    }
}
