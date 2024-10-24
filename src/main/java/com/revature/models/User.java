package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component //registers user as a Spring Bean
@Entity //This class will be created as a table in hte DB
@Table(name = "users") //@Table lets us set properties like table name
public class User {

    @Id //This makes the field the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This makes our primary key auto increment (like serial)
    private int userId;

    /*
    * @Column isn't necessary UNLESS you want to set a name, or set constraints
    * -nullable = not null
    * -unique = unique constraint
    * -columnDefinition = lets you define mroe complext constraints (check, default)
    */

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, columnDefinition = "TEXT DEFAULT 'employee'") //set default role to 'user'
    private String role;

    //boilerplate code


    public User() {
    }

    public User(int userId, String username, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}