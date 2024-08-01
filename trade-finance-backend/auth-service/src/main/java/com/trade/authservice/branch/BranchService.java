package com.trade.authservice.branch;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class BranchService {
    @Autowired
    private BranchRepository branchRepository;
    public Branch getBranchNameByBranchCode(String branchCode){
        if (branchCode==null || branchCode.isEmpty()){
            throw new IllegalArgumentException("branchCode is required");
        }
       Branch branch= branchRepository.findByBranchCode(branchCode);
       return branch;

    }
}
