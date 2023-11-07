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

// TODO Fikse arraylist, plads 0 kommer ikke op når man kører program 2?


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

    public String sortBy(String attributesSort) {
        switch (attributesSort) {
            case "Superhero name", "superheroname", "superhero":
                Collections.sort(superheroList, new ComparatorSuperHeroName());
                /*for (Superhero superhero : superheroList) {
                    if (superhero.getSuperheroName().contains(superhero.getSuperheroName())) {
                        System.out.println(superheroList);
                    }
                }*/
                System.out.println(superheroList);
                break;
            case "First name":
                Collections.sort(superheroList, new ComparatorFirstName());
                System.out.println(superheroList);
                break;
            case "Last name":
                Collections.sort(superheroList, new ComparatorLastName());
                System.out.println(superheroList);
                break;
            case "Abilities":
                Collections.sort(superheroList, new ComparatorAbilities());
                System.out.println(superheroList);
                break;
            case "Species":
                Collections.sort(superheroList, new ComparatorSpecies());
                System.out.println(superheroList);
                break;
        }
       return null;
    }

    public ArrayList<Superhero> getAll(){
    return superheroList;
    }
}