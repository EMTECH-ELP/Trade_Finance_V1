package com.trade.authservice.branch;

import com.trade.authservice.User.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="_branches")
public class Branch {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_code")
    private String branchCode;
    private String branchName;
    @OneToOne(mappedBy = "branch")
    private User user;


}
