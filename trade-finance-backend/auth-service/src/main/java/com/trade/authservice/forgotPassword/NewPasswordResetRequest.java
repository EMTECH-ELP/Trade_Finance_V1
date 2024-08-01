package com.trade.authservice.forgotPassword;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class NewPasswordResetRequest {
    private String email;
}