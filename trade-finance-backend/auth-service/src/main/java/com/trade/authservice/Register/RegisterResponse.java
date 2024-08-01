package com.trade.authservice.Register;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.trade.authservice.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    private Long id;
    private String email;
    private Role role;
    private String employeeID;
    private String branchName;
    private String branchCode;
    private String fullName;

}
