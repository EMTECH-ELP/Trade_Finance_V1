package com.trade.authservice.Requests;

import com.trade.authservice.User.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeRoleRequest {
    private Long id;
    private String email;
    private Role newRole;
}
