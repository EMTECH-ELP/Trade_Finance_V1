package com.trade.authservice.OTP;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "otp")
public class OTP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sn")
    private Integer sn;
    @Column(name = "otp", nullable = false)
    private Integer otp;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "req_time", nullable = false)
    private LocalDateTime requestedTime;
}
