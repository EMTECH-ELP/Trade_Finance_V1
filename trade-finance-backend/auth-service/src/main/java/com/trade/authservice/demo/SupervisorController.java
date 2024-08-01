package com.trade.authservice.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {
    @GetMapping
    public String get() {
        return "GET:: supervisor controller";
    }
    @PostMapping
    public String post() {
        return "POST:: supervisor controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: supervisor controller";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE:: supervisor controller";
    }
}

