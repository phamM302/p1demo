package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Combines @Controller @Responsebody
@RequestMapping("/users") //ALL HTTP requests made to /users will hit this controller
public class UserController {

    private UserService userService;

    //TODO: We need access to the userService
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //TODO: POST request ot insert a new User
    @PostMapping//for post requests
    public ResponseEntity<User> registerUser(@RequestBody User newUser){
        //RequestBody tells Spring to convert the JSON in the Request to a User Object

        //Send the new user to the Service to be inserted and save the returned user
        User u = userService.registerUser(newUser);
        //return the saved user with a 200 status code OK
        return ResponseEntity.ok(u);
    }

    //GET request to get all Users
    @GetMapping //GET requests to /users will come here
    public ResponseEntity<List<User>> getAllUsers(){

        //not much error handling in a get all
        List<User> allUsers = userService.getAllUsers();

        //send the users back with a 200 status code
        return ResponseEntity.ok(allUsers);

    }

    @GetMapping("/{username}") //GET requests to /users/{username} will come here
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){

        //ResponseEntity<?>??? what's that?
        //It lets us send any data type we want in the response
        //I avoid this when possible, it can make debugs pretty annoying
        //But I'll often use it since it's so flexible

        //if no user is found, we can send a message saying no user found
        if(userService.getUserByUsername(username) == null){
            return ResponseEntity.status(404).body("No user found with username: " + username);
        }

        //Return the found User with a 200 status code
        return ResponseEntity.ok(userService.getUserByUsername(username));

    }

    //Exception Handler for IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
        //returns a 400 BAD REQUEST status code with the message from the exception that got caught
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
