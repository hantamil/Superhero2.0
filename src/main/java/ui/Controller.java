package ui;

import domainmodel.Database;
import domainmodel.Superhero;

import java.util.ArrayList;

public class Controller {
    Database database = new Database();
    Superhero superhero;

    public void addSuperhero(String superheroName, String firstName, String lastName, String abilities, String species) {
        database.addSuperhero(superheroName, firstName, lastName, abilities, species);
    }

    public ArrayList<Superhero> getSuperheroList() {
        return database.superheroList;
    }

    public ArrayList<String> findSuperheroesNames(String superheroName) {
        return database.findSuperheroesNames(superheroName);
    }

    public void deleteSuperhero (String superheroName){
        database.deleteSuperhero(superheroName);
    }

    public ArrayList<Superhero> findSuperhero(String superheroName){
        return database.findSuperhero(superheroName);
    }

    public String getSuperheroName(){
        return superhero.getSuperheroName();
    }

}
