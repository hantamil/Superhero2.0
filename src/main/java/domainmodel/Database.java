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

    public void deleteSuperhero(String superheroName) {
        String lowercaseSearch = superheroName.toLowerCase();

        Superhero superheroToDelete = null;
        for (Superhero superhero : superheroList) {
            if (superhero.getSuperheroName().equalsIgnoreCase(lowercaseSearch)) {
                superheroToDelete = superhero;
                break;
            }
        }
        if (superheroToDelete != null) {
            superheroList.remove(superheroToDelete);
            System.out.println(superheroName + " has been " + "\u001B[31m" + "deleted" + "\u001B[0m" + " from your library.");
        } else {
            System.out.println(superheroName + " does not exist in our database. No deletion performed.");
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

    public ArrayList<Superhero> getAll() {
        return superheroList;
    }

    public String sortByMultipleAttributes(String attribute1, String attribute2) {
        System.out.println("Sorted by first attribute:");
        switch (attribute1) {
            case "2":
                Collections.sort(superheroList, new ComparatorFirstName());
                for (Superhero superhero : superheroList) {
                    System.out.println("\nSuperhero name: " + superhero.getSuperheroName());
                    System.out.println("First name: " + superhero.getFirstName());
                }
                break;
            case "3":
                Collections.sort(superheroList, new ComparatorLastName());
                for (Superhero superhero : superheroList) {
                    System.out.println("\nSuperhero name: " + superhero.getSuperheroName());
                    System.out.println("Last name: " + superhero.getLastName());
                }
                break;
            case "4":
                Collections.sort(superheroList, new ComparatorAbilities());
                for (Superhero superhero : superheroList) {
                    System.out.println("\nSuperhero name: " + superhero.getSuperheroName());
                    System.out.println("Abilities: " + superhero.getAbilities());
                }
                break;
            case "5":
                Collections.sort(superheroList, new ComparatorSpecies());
                for (Superhero superhero : superheroList) {
                    System.out.println("\nSuperhero name: " + superhero.getSuperheroName());
                    System.out.println("Species: " + superhero.getSpecies());
                }
                break;
        }

        System.out.println("\nSorted by second attribute:");
        switch (attribute2) {
            case "2":
                Collections.sort(superheroList, new ComparatorFirstName());
                for (Superhero superhero : superheroList) {
                    System.out.println("\nSuperhero name: " + superhero.getSuperheroName());
                    System.out.println("First name: " + superhero.getFirstName());
                }
                break;
            case "3":
                Collections.sort(superheroList, new ComparatorLastName());
                for (Superhero superhero : superheroList) {
                    System.out.println("\nSuperhero name: " + superhero.getSuperheroName());
                    System.out.println("Last name: " + superhero.getLastName());
                }
                break;
            case "4":
                Collections.sort(superheroList, new ComparatorAbilities());
                for (Superhero superhero : superheroList) {
                    System.out.println("\nSuperhero name: " + superhero.getSuperheroName());
                    System.out.println("Abilities: " + superhero.getAbilities());
                }
                break;
            case "5":
                Collections.sort(superheroList, new ComparatorSpecies());
                for (Superhero superhero : superheroList) {
                    System.out.println("\nSuperhero name: " + superhero.getSuperheroName());
                    System.out.println("Species: " + superhero.getSpecies());
                }
                break;
        }
        return "";
    }
}