package com.encode.fresh.auth;

import com.encode.fresh.utils.Response.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/v1/users")
public class UsersController {

//    @Autowired
//    UsersService usersService;

    @Autowired
    UsersRepository usersRepository;

    public UsersController(){

    }

    @PostMapping("add")
    public ResponseEntity<Object> saveUser(@RequestBody Users users){
        ApiResponse response = new ApiResponse();
        try {
            Users savedUser = usersRepository.save(users);


            response.setMessage("Created");
            response.setStatusCode(HttpStatus.CREATED.value());
            response.setEntity(savedUser);

            return new  ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error occurred "+ e);
            return  null;
        }

    }

    @GetMapping("/fetch")
    public ResponseEntity<Object> fetchUsers(){
        ApiResponse response = new ApiResponse();
        try {
            List<Users> users = usersRepository.findAll();


            response.setMessage("Found");
            response.setStatusCode(HttpStatus.FOUND.value());
            response.setEntity(users);

            return new  ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Error occurred "+ e);
            return  null;
        }

    }




}
