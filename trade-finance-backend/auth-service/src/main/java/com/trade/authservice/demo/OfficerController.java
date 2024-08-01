package com.trade.authservice.demo;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/officer")
public class OfficerController {
    @GetMapping
    public String get() {
        return "GET:: officer controller";
    }
    @PostMapping
    public String post() {
        return "POST:: officer controller";
    }
    @PutMapping
    public String put() {
        return "PUT:: officer controller";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE:: officer controller";
    }
}