package com.Ikbsu.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patrol_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatrolDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patrolDetailId;

    @ManyToOne
    @JoinColumn(name = "patrol_id", nullable = false)
    private Patrol patrol;

    @ManyToOne
    @JoinColumn(name = "gr_number", nullable = false)
    private Scout scout;
}
