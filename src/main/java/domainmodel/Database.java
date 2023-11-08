package domainmodel;

import datasource.FileHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

    public void deleteSuperhero(String superheroName) {
        int foundIndex;
        for (int superhero = 0; superhero < superheroList.size(); superhero++) {
            if (superheroList.get(superhero).getSuperheroName().equalsIgnoreCase(superheroName)) {
                foundIndex = superhero;
                superheroList.remove(foundIndex);
                return;
            }
        }
    }

    public String sortBy(String attributeSort) {
        switch (attributeSort.toLowerCase()) {
            case "superhero name":
                Collections.sort(superheroList, new ComparatorSuperHeroName());
                System.out.println("Sorted alphabetically by superhero name:\n");
                for (Superhero superhero : superheroList) {
                    String superheroName = superhero.getSuperheroName();
                    String name = superhero.getSuperheroName();
                    System.out.println(name + ": " + superheroName);
                }
                break;
            case "first name":
                Collections.sort(superheroList, new ComparatorFirstName());
                System.out.println("Sorted alphabetically by first name:\n");
                for (Superhero superhero : superheroList) {
                    String firstName = superhero.getFirstName();
                    String name = superhero.getSuperheroName();
                    System.out.println(name + ": " + firstName);
                }
                break;
            case "last name":
                Collections.sort(superheroList, new ComparatorLastName());
                System.out.println("Sorted alphabetically by last name:\n");
                for (Superhero superhero : superheroList) {
                    String lastName = superhero.getLastName();
                    String name = superhero.getSuperheroName();
                    System.out.println(name + ": " + lastName);
                }
                break;
            case "abilities":
                Collections.sort(superheroList, new ComparatorAbilities());
                System.out.println("Sorted alphabetically by abilities:\n");
                for (Superhero superhero : superheroList) {
                    String abilities = superhero.getAbilities();
                    String name = superhero.getSuperheroName();
                    System.out.println(name + ": " + abilities);
                }
                break;
            case "species":
                Collections.sort(superheroList, new ComparatorSpecies());
                System.out.println("Sorted alphabetically by species:\n");
                for (Superhero superhero : superheroList) {
                    String species = superhero.getSpecies();
                    String name = superhero.getSuperheroName();
                    System.out.println(name + ": " + species);
                }
                break;
        }
        return "";
    }

    public ArrayList<Superhero> getAll(){
    return superheroList;
    }

    public int sortByMultipleAttributes(int attribute1, int attribute2){
        ArrayList<Superhero> sortedList = superheroList;

        Collections.sort(sortedList, new ComparatorSuperHeroName());

        if (attribute1 == 2) {
            Collections.sort(sortedList, new ComparatorFirstName());
            for (Superhero superhero : sortedList){
                System.out.println("First name: " + superhero.getFirstName());
            }
        } else if (attribute1 == 3) {
            Collections.sort(sortedList, new ComparatorLastName());
            for (Superhero superhero : sortedList){
                System.out.println("Last name: " + superhero.getLastName());
            }
        } else if (attribute1 == 4) {
            Collections.sort(sortedList, new ComparatorAbilities());
            for (Superhero superhero : sortedList){
                System.out.println("Abilities: " + superhero.getAbilities());
            }
        } else if (attribute1 == 5) {
            Collections.sort(sortedList, new ComparatorSpecies());
            for (Superhero superhero : sortedList){
                System.out.println("Species: " + superhero.getSpecies());
            }
        }

        if (attribute2 == 2) {
            Collections.sort(sortedList, new ComparatorFirstName());
            for (Superhero superhero : sortedList){
                System.out.println("First name: " + superhero.getFirstName());
            }
        } else if (attribute2 == 3) {
            Collections.sort(sortedList, new ComparatorLastName());
            for (Superhero superhero : sortedList){
                System.out.println("Last name: " + superhero.getLastName());
            }
        } else if (attribute2 == 4) {
            Collections.sort(sortedList, new ComparatorAbilities());
            for (Superhero superhero : sortedList){
                System.out.println("Abilities: " + superhero.getAbilities());
            }
        } else if (attribute2 == 5) {
            Collections.sort(sortedList, new ComparatorSpecies());
            for (Superhero superhero : sortedList){
                System.out.println("Species: " + superhero.getSpecies());
            }
        }

        return attribute1 + attribute2;
    }
}