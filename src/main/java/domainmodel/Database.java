package domainmodel;

import datasource.FileHandler;

import java.util.ArrayList;
import java.util.Collections;

public class Database {
    FileHandler fh = new FileHandler();

    private ArrayList<Superhero> superheroList;

    public Database() {
        this.superheroList = fh.loadData();
        Collections.sort(superheroList);
    }

    public void addSuperhero(String superheroName, String firstName, String lastName, String abilities, String species) {
        Superhero superhero = new Superhero(superheroName, firstName, lastName, abilities, species);
        superheroList.add(superhero);
    }

    public ArrayList<Superhero> findSuperhero(String superheroName) {
        ArrayList<Superhero> searchSHN = new ArrayList<>();

        for (Superhero superhero : superheroList) {
            if (superhero.getSuperheroName().toLowerCase().contains(superheroName.toLowerCase())) {
                searchSHN.add(superhero);
            }
        }
        return searchSHN;
    }

    public ArrayList<String> findSuperheroesNames(String superheroName) {
        ArrayList<Superhero> superheroes = findSuperhero(superheroName);
        ArrayList<String> superheroNames = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            superheroNames.add(superhero.getSuperheroName());
        }
        return superheroNames;
    }

    public void deleteSuperhero (String superheroName){
        int foundIndex;
        for (int superhero = 0; superhero < superheroList.size(); superhero++){
            if(superheroList.get(superhero).getSuperheroName().equalsIgnoreCase(superheroName)){
                foundIndex = superhero;
                superheroList.remove(foundIndex);
                return;
            }
        }
    }

    public ArrayList<Superhero> getAll(){
    return superheroList;
    }
}