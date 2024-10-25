package com.revature.models.DTOs;

public class IncomingPetDTO {

    private String species;
    private String name;
    private int userId;

    //boilerplate code--------------------------

    public IncomingPetDTO() {
    }

    public IncomingPetDTO(String species, String name, int userId) {
        this.species = species;
        this.name = name;
        this.userId = userId;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PetDTO{" +
                "species='" + species + '\'' +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}