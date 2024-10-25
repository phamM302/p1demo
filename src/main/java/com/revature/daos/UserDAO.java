package com.revature.daos;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//By extending JpaRepository we get access to various DAO methods that we do not need to write
@Repository// 1 of 4 stereotype annotations
public interface UserDAO extends JpaRepository<User, Integer> {

    /*I want to be able to find a User by their username
      Unfortunately, Spring Data doesn't have a built in method for that
      So we have to define our own method signature, and Spring will implement it for us
      ****This is called a PROPERTY EXPRESSION */
    User findByUsername(String username);


}
