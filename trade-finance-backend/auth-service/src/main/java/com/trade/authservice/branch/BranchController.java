package com.trade.authservice.branch;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("api/branch")
@RequiredArgsConstructor
@CrossOrigin("*")


public class BranchController {
    @Autowired
    private  BranchService branchService;
    @GetMapping("/code")
    public ResponseEntity<?> getBranchNameByBranchCode(@RequestParam String branchCode){
        try {
            Branch branch= branchService.getBranchNameByBranchCode(branchCode);
            Map<String, String> response= new LinkedHashMap<>();

//            response.put("branchName",branchName);
//            response.put("branchCode",branchCode);
            return ResponseEntity.ok(branch);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


}
