package com.trade.authservice.Register;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    @JsonProperty("access_token")
    public String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    private Long id;
    private String email;
    private String role;
    private Character firstLogin;
    private boolean otpRequired = true;

}