package com.Ikbsu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Timestamp;
import java.util.Date;

@Entity
@Table(name = "annual_fee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnnualFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer annualFeeId;

    private Integer receiptNumber;
    private Integer fee;
    private Integer patrolFund;
    private Integer lateFee;
    private Integer total;
    private Date feeReceivingDate;
    private Timestamp feePunchingDate;

    @ManyToOne
    @JoinColumn(name = "gr_number", nullable = false)
    private Scout scout;
}
