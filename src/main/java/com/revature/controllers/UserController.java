package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //Exception Handler for IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
        //returns a 400 BAD REQUEST status code with the message from the exception that got caught
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
