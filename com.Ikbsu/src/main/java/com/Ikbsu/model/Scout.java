package com.Ikbsu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scout")
public class Scout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer grNumber;


    private String cardNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String primaryPhoneNumber;
    private String secondaryPhoneNumber;
    private String address;
    private Date dateOfBirth;
    private String placeOfBirth;
    private String nic;
    private ScoutStatus status;
    private String rank_name;
    private String qualification;
    private String occupation;
    private Date dateOfJoining;
    private Date dateOfLeaving;

    // Relationships
    @OneToMany(mappedBy = "scout")
    private List<AttendanceDetail> attendanceDetails;

    @OneToMany(mappedBy = "scout")
    private List<AnnualFee> annualFees;

    @OneToMany(mappedBy = "scout")
    private List<PatrolDetail> patrolDetails;

}
