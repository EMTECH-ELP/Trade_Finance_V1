package com.trade.authservice.demo;

import com.trade.authservice.AuditTrail.AuditTrailService;
import com.trade.authservice.Register.RegisterRequest;
import com.trade.authservice.Requests.ChangeRoleRequest;
import com.trade.authservice.User.User;
import com.trade.authservice.User.UserDto;
import com.trade.authservice.User.UserRepository;
import com.trade.authservice.User.UserStatusDto;
import com.trade.authservice.utils.EntityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.trade.authservice.utils.Status.ACTIVE;
import static com.trade.authservice.utils.Status.FLAGGED;



@RestController
@CrossOrigin
@Slf4j
@RequestMapping("auth/admin")
//@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuditTrailService auditTrailService;
    @Autowired
    public AdminController(AdminService adminService, UserRepository userRepository){
        this.adminService = adminService;
        this.userRepository = userRepository;
    }

    @PostMapping("/unlockAccountById")
    public EntityResponse<?> unlockAccountById(@RequestParam Long id) {
        return adminService.unlockAccountById(id);

    }
    @PostMapping("/unlockAccountByEmail")
    public EntityResponse<?> unlockAccountByEmail(@RequestParam String email) {
        return adminService.unlockAccountByEmail(email);

    }

    @PostMapping("/addNewUser")
//     @PreAuthorize("hasRole('ADMIN')")
    public EntityResponse addNewUser(@RequestBody RegisterRequest request) {
        return adminService.addNewUser(request);
    }


    @GetMapping("/getAllUsers")
//    @PreAuthorize("hasAuthority('admin:read')")
    public EntityResponse<List<UserDto>> getAllUsers() throws Exception {
        return adminService.getAllUsers();
    }
    @GetMapping("/findByEmail")
    public EntityResponse findByEmail(@RequestParam String email){
        return adminService.findUserByEmail(email);
    }
    @GetMapping("/getUserId")
    public EntityResponse getUserById(@RequestParam Long id){
        return adminService.findUserById(id);
    }
    @GetMapping("/findAllLockedAccounts")
    public List<User> findAllLockedAccounts() {
        return adminService.findAllLockedAccounts();
    }


    @PutMapping("/changeUserRoleById")
//    @PreAuthorize("hasAuthority('admin:update')")
    public EntityResponse<?> changeUserRoleById(@RequestBody ChangeRoleRequest request) {
        return adminService.changeUserRoleById(request);
    }
    @PutMapping("/changeUserRoleByEmail")
//    @PreAuthorize("hasAuthority('admin:update')")
    public EntityResponse<?> changeUserRoleByEmail(@RequestBody ChangeRoleRequest request) {
        return adminService.changeUserRoleByEmail(request);
    }


    @DeleteMapping("/deleteUser")
//    @PreAuthorize("hasRole('ADMIN')")
    public  EntityResponse deleteUser(@RequestParam Long id){
        return adminService.deleteUserById(id);
    }


    @PutMapping("/approveOrReject")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> approveOrReject(@RequestBody List<UserStatusDto>userStatusDtoList, @RequestParam String remarks) {
        EntityResponse response = new EntityResponse<>();
        try {
            if (userStatusDtoList.isEmpty()) {
                response.setMessage("Provide at least one user for approval or rejection");
                response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
            } else {
                List<User>updatedUsers = new ArrayList<>();
                for (UserStatusDto userStatusDto : userStatusDtoList){
                    Optional<User> optionalUser = userRepository.findById(userStatusDto.getSn());
                    if (optionalUser.isPresent()){
                        User user = optionalUser.get();

                        String Status = userStatusDto.getStatus().toUpperCase();
                        switch (Status) {
                            case "ACTIVE":
                                user.setStatus(ACTIVE);
                                user.setApprovedFlag('Y');
                                user.setApprovedTime(LocalDateTime.now());
                                user.setRemarks(remarks);
                                break;
                            case "FLAGGED":
                                user.setStatus(FLAGGED);
                                user.setApprovedFlag('N');
                                user.setApprovedTime(null);
                            default:
                                response.setMessage("Invalid Status provided: "+ Status);
                                response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
                                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
                        }
                        updatedUsers.add(userRepository.save(user));

                    } else {
                        response.setMessage("No user found with such an Id: "+ userStatusDto.getSn());
                        response.setStatusCode(HttpStatus.NOT_FOUND.value());
                        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(response);

                    }
                }
                response.setMessage("User Status updated Successfully");
                response.setStatusCode(HttpStatus.OK.value());
                response.setEntity(updatedUsers);
            }
        }catch (Exception e){
            log.error(e.toString());
            response.setMessage("An unexpected error occurred while updating status");
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

        } return ResponseEntity.ok(response);
    }

}