package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Column()
    private String role;

    /*One to Many relationship (goes hand in hand with the @ManyToOne in Pet)

     mappedBy: This refers to the @ManyToOne field in Pet that maps this relationship (user)

     fetch: refer to the Pet class for info on this guy

     cascade: This lets us define what operations cascade down to dependent records\
        -CascadeType.ALL = all operations cascade down to dependent records (update, delete, etc) */
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore //prevents circular reference
    private List<Pet> pets;

    //boilerplate code


    public User() {
        this.role = "employee";
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
