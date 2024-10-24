package com.revature.services;


import com.revature.daos.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//1 of the 4 stereotype annotations it registers thsi class as a Spring Bean
public class UserService {

    private UserDAO userDAO;

    //Constructor Injection
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    //this method inserts new users into the DB
    public User registerUser(User newUser) {
        //error handling
        //TODO: check that the username is unique
        if (newUser.getUsername() == null || newUser.getUsername().isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        //.save is the JPA method to insert data into the DB
        //it also returns the saved object, so we can just return the method call
        return userDAO.save(newUser);
    }
}
