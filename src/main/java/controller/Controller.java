package controller;

import datasource.FileHandler;
import domainmodel.*;

import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private Database database = new Database();

    public void addSuperhero(String superheroName, String firstName, String lastName, String abilities, String species) {
        database.addSuperhero(superheroName, firstName, lastName, abilities, species);
    }

    public ArrayList<Superhero> getSuperheroList() {
        return database.getAll();
    }

    public void deleteSuperhero (String superheroName){
        database.deleteSuperhero(superheroName);
    }

    public ArrayList<Superhero> findSuperhero(String superheroName){
        return database.findSuperhero(superheroName);
    }

    public String getSortBy(String attributesSort) {
        return database.sortBy(attributesSort);
    }

    public String getSortByMultipleAttributes(String attribute1, String attribute2){
        return database.sortByMultipleAttributes(attribute1, attribute2);
    }
}