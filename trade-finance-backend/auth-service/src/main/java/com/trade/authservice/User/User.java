package com.trade.authservice.User;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trade.authservice.AuditTrail.Auditable;
import com.trade.authservice.Token.Token;
import com.trade.authservice.branch.Branch;
import com.trade.authservice.utils.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class User extends Auditable<String> implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( length = 50)
    private String fullName;
//    private String lastname;
    @Email
    @Column(unique = true)
    private String email;
    private String password;
    private String employeeID;
    private String branchName;
    private String branchCode;
    private int failedLoginAttempts;
    private boolean accountLocked;
    @Column(name = "first_login", length = 1)
    private Character firstLogin;


    @JsonProperty
    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 25)
    private Role role;




    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @JsonProperty
    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 25)
    private Status status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Character approvedFlag;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime approvedTime;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String remarks;
    @Column(name = "deleteFlag", length = 5)
    private Character deletedFlag;

    @OneToOne(cascade = CascadeType.ALL)
    private Branch branch;

    // ...

    public boolean getAccountLocked() {
        return accountLocked;
    }
    public void resetFailedAttempts() {
        this.failedLoginAttempts = 0;
    }



    public void unlockAccount() {
        this.setAccountLocked(false); // Assuming you already have a setAccountLocked method
    }


    public void incrementFailedAttempts() {
        this.failedLoginAttempts++;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();

    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}


