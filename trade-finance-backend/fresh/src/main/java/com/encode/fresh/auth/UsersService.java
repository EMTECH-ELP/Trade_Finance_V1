package com.encode.fresh.auth;

import org.springframework.beans.factory.annotation.Autowired;

public class UsersService {

    @Autowired
    UsersRepository usersRepository;
    public Users saveUser(Users user) {
        Users saved = usersRepository.save(user);
        return  saved;
    }
}
