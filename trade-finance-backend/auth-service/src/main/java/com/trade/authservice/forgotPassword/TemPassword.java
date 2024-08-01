package com.trade.authservice.forgotPassword;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tem_password")
@Component

public class TemPassword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "tem_password", nullable = false)
    private String temPassword;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "req_time", nullable = false)
    private Date requestedTime;
}

