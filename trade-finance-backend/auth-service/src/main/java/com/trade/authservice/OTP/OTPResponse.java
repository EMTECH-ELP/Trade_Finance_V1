package com.trade.authservice.OTP;

import com.trade.authservice.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OTPResponse {
    private Long id;
    private String email;
    public String accessToken;
    private Role role;

}