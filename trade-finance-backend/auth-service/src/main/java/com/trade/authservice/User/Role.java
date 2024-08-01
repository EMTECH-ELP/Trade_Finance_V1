package com.trade.authservice.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.trade.authservice.User.Permission.*;


@Getter
@RequiredArgsConstructor
public enum Role {
    //    USER(Collections.emptySet()),
    SUPER_ADMIN(
            Set.of(
                    SUPER_ADMIN_READ,
                    SUPER_ADMIN_UPDATE,
                    SUPER_ADMIN_CREATE,
                    SUPER_ADMIN_DELETE,
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    CHECKER_READ,
                    CHECKER_UPDATE,
                    CHECKER_DELETE,
                    CHECKER_CREATE,
                    MAKER_READ,
                    MAKER_UPDATE,
                    MAKER_CREATE,
                    MAKER_DELETE
            )),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    CHECKER_READ,
                    CHECKER_UPDATE,
                    CHECKER_DELETE,
                    CHECKER_CREATE,
                    MAKER_READ,
                    MAKER_UPDATE,
                    MAKER_CREATE,
                    MAKER_DELETE
            )),
    CHECKER(
            Set.of(
                    CHECKER_READ,
                    CHECKER_UPDATE,
                    CHECKER_DELETE,
                    CHECKER_CREATE,
                    MAKER_READ,
                    MAKER_UPDATE,
                    MAKER_CREATE,
                    MAKER_DELETE
            )),
    MAKER(
            Set.of(
                    MAKER_READ,
                    MAKER_UPDATE,
                    MAKER_CREATE,
                    MAKER_DELETE
            )
    );



    private final Set<Permission> permissions;
    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission-> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
