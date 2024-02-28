package com.encode.fresh.utils.Session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Activesession {
    private UUID uuid;
    private String username;
    private String Status;
    private String loginAt;
    private String address;
    private String os;
    private String browser;
}
