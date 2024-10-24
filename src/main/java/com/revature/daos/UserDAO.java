package com.revature.daos;

import com.revature.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//By extending JpaRepository we get access to various DAO methods that we do not need to write
@Repository// 1 of 4 stereotype annotations
public interface UserDAO extends JpaRepository<User, Integer> {
}
