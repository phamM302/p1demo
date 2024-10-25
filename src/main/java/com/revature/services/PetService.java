package com.revature.services;

//Check UserService for general notes on Services

import com.revature.daos.PetDAO;
import com.revature.daos.UserDAO;
import com.revature.models.DTOs.IncomingPetDTO;
import com.revature.models.Pet;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Makes a class a bean. Stereotype annotation.
public class PetService {

    //autowire the PetDAO with constructor injection so we can use the PetDAO methods
    private PetDAO pDAO;
    private UserDAO uDAO;

    @Autowired
    public PetService(PetDAO pDAO, UserDAO uDAO) {
        this.pDAO = pDAO;
        this.uDAO = uDAO;
    }

    //This method takes in a new Pet object and inserts it into the DB
    public Pet addPet(IncomingPetDTO petDTO) {
        Pet newPet = new Pet(0, petDTO.getSpecies(), petDTO.getName(), null);
        Optional<User> u = uDAO.findById(petDTO.getUserId());

        if(u.isEmpty()) {
            throw new IllegalArgumentException("No user foudn with id: " + petDTO.getUserId());
        } else {
            newPet.setUser(u.get());
            return pDAO.save(newPet);
        }
    }

    public List<Pet> getAllPets() {
        return pDAO.findAll();
    }


}