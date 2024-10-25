package com.revature.daos;

import com.revature.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Check UserDAO for general notes about how Spring Data DAOs work

@Repository //make this class a Bean (1 of the 4 steretype annotations)
public interface PetDAO extends JpaRepository<Pet, Integer> {



}