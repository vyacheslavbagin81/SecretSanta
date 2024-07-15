package com.example.secretsanta.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name = "Groups")
@Getter
@EqualsAndHashCode
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameGroup;
    private float costLimit;
    private LocalDateTime endOfRegistration;
    private LocalDateTime exchangeOfGifts;
    @ManyToMany
    @JoinTable(
            name = "group_participant",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id"))
    private ArrayList<Participant> participants;

    public Group() {
    }
}
