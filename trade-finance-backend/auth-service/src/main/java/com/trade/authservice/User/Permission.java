package com.trade.authservice.User;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Permission {
    SUPER_ADMIN_READ("supper_admin:read"),
    SUPER_ADMIN_UPDATE("supper_admin:update"),
    SUPER_ADMIN_CREATE("supper_admin:create"),
    SUPER_ADMIN_DELETE("supper_admin:delete"),
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin_create"),
    ADMIN_DELETE("admin_delete"),
    CHECKER_READ("checker:read"),
    CHECKER_UPDATE("checker:update"),
    CHECKER_CREATE("checker:create"),
    CHECKER_DELETE("checker:delete"),
    MAKER_READ("maker:read"),
    MAKER_UPDATE("maker:update"),
    MAKER_CREATE("maker:create"),
    MAKER_DELETE("maker:delete")
    ;


    private final String permission;
}


