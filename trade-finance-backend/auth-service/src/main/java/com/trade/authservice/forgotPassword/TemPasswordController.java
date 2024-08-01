package com.trade.authservice.forgotPassword;

import com.trade.authservice.utils.EntityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class TemPasswordController {
    @Autowired
    private TemPassword temPassword;

    @Autowired
    private TemPasswordService temPasswordService;



    @PostMapping("/temPassword")
    EntityResponse<?> sendTemPassword(@RequestParam String email) {
        return temPasswordService.sendTemPassword(email);
    }

    @PostMapping("/resetPassword")
    public ResponseEntity<EntityResponse> resetPassword(@RequestBody ResetPasswordRequest reset) {
        try {
            EntityResponse response = (EntityResponse) temPasswordService.resetPassword(reset);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return null;
        }
    }

}
