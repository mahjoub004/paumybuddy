package com.PayMyBuddyV1.repository;

import com.PayMyBuddyV1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value="SELECT u FROM User u LEFT JOIN FETCH u.connections WHERE u.email=:email ")
    Optional<User> findUserByMail(String email);
}
