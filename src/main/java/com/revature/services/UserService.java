package com.revature.services;


import com.revature.daos.UserDAO;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> getAllUsers(){
        //findAll() is a JPA method that returns all records in a table
        return userDAO.findAll();

        //Not much error handling in a get all... maybe checking to see if it's empty?
    }

    public User getUserByUsername(String username){

        //a little error handling
        if(username == null || username.isBlank()){
            throw new IllegalArgumentException("Please search for a valid username!");
        }

        //TODO: we could check if the returned user is null and throw an exception
        //if(userDAO.findByUsername(username) == null){throw Exp}

        //findByUsername is a method WE DEFINED in the UserDAO (but didn't have to implement!)
        return userDAO.findByUsername(username);
    }

}
