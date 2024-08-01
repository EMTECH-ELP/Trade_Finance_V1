package com.trade.authservice.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByEmail(String Email);

    boolean existsByEmail(String Email);
    List<User> findAllByAccountLockedTrue();

//    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE email = :email")
//    List<User> validPassword(String email);
}
