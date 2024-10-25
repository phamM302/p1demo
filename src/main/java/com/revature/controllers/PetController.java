package com.revature.controllers;

import com.revature.models.DTOs.IncomingPetDTO;
import com.revature.models.Pet;
import com.revature.models.User;
import com.revature.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private PetService petService;

    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

    //A method that inserts a new pet into the DB
    @PostMapping
    public ResponseEntity<Pet> registerPet(@RequestBody IncomingPetDTO petDTO) {
        Pet p = petService.addPet(petDTO);
        //send the new Pet data back to the client with 201 - CREATED
        return ResponseEntity.status(201).body(p);
    }

    @GetMapping
    public ResponseEntity<List<Pet>> getAllPets() {
        //not much error handling in a get all
        List<Pet> allPets = petService.getAllPets();

        //send the users back with a 200 status code
        return ResponseEntity.ok(allPets);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException e) {
        //returns a 400 BAD REQUEST status code with the message from the exception that got caught
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
