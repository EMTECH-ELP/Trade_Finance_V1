package com.trade.authservice.Register;

import com.trade.authservice.User.Role;
import com.trade.authservice.utils.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.trade.authservice.utils.Status.ACTIVE;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private String branchName;
    private String branchCode;
    private String employeeID;

    @Enumerated(EnumType.STRING)
//    private Status status = PENDING;
    private Status status = ACTIVE;

    @Enumerated(EnumType.STRING)
    private Role role;
}