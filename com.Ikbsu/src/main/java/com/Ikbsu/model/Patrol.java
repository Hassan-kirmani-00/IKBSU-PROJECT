package com.Ikbsu.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "patrol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patrol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patrolId;

    private String patrolName;

    @OneToMany(mappedBy = "patrol")
    private List<PatrolDetail> patrolDetails;
}
