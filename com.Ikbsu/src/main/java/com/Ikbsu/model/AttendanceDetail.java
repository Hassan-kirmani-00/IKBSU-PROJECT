package com.Ikbsu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "attendance_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceDetailId;

    @ManyToOne
    @JoinColumn(name = "attendance_id", nullable = false)
    private Attendance attendance;

    @ManyToOne
    @JoinColumn(name = "gr_number", nullable = false)
    private Scout scout;
}
