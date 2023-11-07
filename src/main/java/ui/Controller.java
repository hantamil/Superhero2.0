package ui;

import datasource.FileHandler;
import domainmodel.Database;
import domainmodel.Superhero;

import java.util.ArrayList;

public class Controller {
    private Database database = new Database();

    public void addSuperhero(String superheroName, String firstName, String lastName, String abilities, String species) {
        database.addSuperhero(superheroName, firstName, lastName, abilities, species);
    }

    public ArrayList<Superhero> getSuperheroList() {
        return database.getAll();
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

    public String getSortBy(String attributesSort) {
        return database.sortBy(attributesSort);
    }


}
