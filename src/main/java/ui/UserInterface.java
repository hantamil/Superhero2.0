package ui;

import domainmodel.Superhero;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class UserInterface {
    public static final String BLUE_BOLD = "\033[1;34m";

    private int scanIntWithRetry() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("Not a number! Try again");
        }
        return scanner.nextInt();
    }

    public void startProgram() {
        Controller controller = new Controller();
        controller.getSuperheroList();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to the SUPERHERO UNIVERSE!");
        boolean runProgram = true;


        int menuNumber;

        // når vores superheros skal gennems i en fil, vil det være en fordel med .csv, da det betyder at filen er komma opdelt - vi kan have alt i en fil
        // i stedet for at lave filer til alle strings i superhero
        while (runProgram) {
            System.out.println("\nChoose your next step and enter a number:");
            System.out.println("1. Create");
            System.out.println("2. See complete list of superhero");
            System.out.println("3. Search for superhero");
            System.out.println("4. Edit superhero");
            System.out.println("5. Delete superhero");
            System.out.println("9. Close");

            menuNumber = scanIntWithRetry();

            switch (menuNumber) {
                //TODO Create
                case 1:
                    System.out.println("Enter the superhero name: ");
                    String superheroName = keyboard.next();
                    System.out.println("Enter the superhero's legal name (first and last): ");
                    String firstName = keyboard.next();
                    String lastName = keyboard.next();
                    System.out.println("Enter superpower: ");
                    String abilities = keyboard.next();
                    System.out.println("Enter which kind of creature the superhero is: ");
                    String species = keyboard.next();
                    System.out.println("The superhero you have added: " +
                            superheroName + " " +
                            firstName + lastName + " " +
                            abilities + " " + species);
                    keyboard.nextLine();

                    controller.addSuperhero(superheroName, firstName, lastName, abilities, species);
                    break;

                //TODO See complete list of Superheroes
                case 2:
                    if (controller.getSuperheroList().isEmpty()) {
                        System.out.println("No superhero found");
                    } else {
                        System.out.println("Complete list of superheroes:" + controller.getSuperheroList());
                    /*for (Superhero superhero1 : superheroList) {
                        if (superhero1 != null)
                            System.out.println(BLUE_BOLD + " domainmodel.Superhero: " + superhero1.getSuperheroName() +
                                    "\u001B[0m" + "\n" +
                                    " Name: " + superhero1.getFirstName() + " " + superhero1.getLastName() + "\n" +
                                    " Abilities: " + superhero1.getAbilities() + "\n" +
                                    " Species: " + superhero1.getSpecies());
                    }*/
                }
                        break;

                        //TODO Search for Superheroes
                        case 3:
                            controller.getSuperheroName();
                            System.out.println("Enter the superhero name");
                            //final String superheroName = keyboard.next();

                            if (controller.findSuperheroesNames(controller.getSuperheroName()).isEmpty()) {
                                System.out.println("This superhero does not exist in our library of superheroes.");
                            } else {
                                System.out.println(controller.getSuperheroName());
                            }
                            break;

                        //TODO Edit Superheroes
                        case 4:
                            System.out.println("Enter the name of the superhero you would like to edit:");
                            final String searchSHName = keyboard.nextLine();
                            ArrayList<Superhero> searchSHN = controller.findSuperhero(searchSHName);

                            if (!searchSHN.isEmpty()) {
                                System.out.println("Superheroes have been found.");

                                for (int index = 0; index < searchSHN.size(); index++) {
                                    System.out.println((index + 1) + ". " + searchSHN.get(index).getSuperheroName());
                                    System.out.println();
                                }

                                System.out.println("Type in number of the superhero you would like to edit:");
                                int superheroNumber = scanIntWithRetry();
                                Superhero editSuperhero = searchSHN.get(superheroNumber - 1);

                                System.out.println("Edit the data and press ENTER. If the data does not require changes, then press ENTER.");

                                System.out.println("domainmodel.Superhero Name: " + editSuperhero.getSuperheroName());
                                String newSuperheroName = keyboard.nextLine();
                                if (!newSuperheroName.isEmpty())
                                    editSuperhero.setSuperheroName(newSuperheroName);

                                System.out.println("First name: " + editSuperhero.getFirstName());
                                String newFirstName = keyboard.nextLine();
                                if (!newFirstName.isEmpty())
                                    editSuperhero.setFirstName(newFirstName);

                                System.out.println("Last name: " + editSuperhero.getLastName());
                                String newLastName = keyboard.nextLine();
                                if (!newLastName.isEmpty())
                                    editSuperhero.setLastName(newLastName);

                                System.out.println("Abilities: " + editSuperhero.getAbilities());
                                String newAbilities = keyboard.nextLine();
                                if (!newAbilities.isEmpty())
                                    editSuperhero.setAbilities(newAbilities);

                                System.out.println("Type: " + editSuperhero.getSpecies());
                                String newSpecies = keyboard.nextLine();
                                if (!newSpecies.isEmpty())
                                    editSuperhero.setSpecies(newSpecies);
                            } else {
                                System.out.println("No results match your search: " + searchSHName);
                            }
                            break;
/*
                        //TODO Delete Superheroes
                        case 5:
                            System.out.println("Enter the superhero you want to delete: ");
                            final String searchSHN = keyboard.nextLine();
                            ArrayList<Superhero> searchSHN = controller.findSuperhero(searchSHName);
                            if (!searchSHN.isEmpty()) {
                                System.out.println("This superhero does not exits in our database");
                                final String searchSHName = keyboard.nextLine();
                   /* for (int superhero = 0; superhero < superheroName.size(); superhero++){
                        System.out.println(superhero + 1 + ".\n" + superheroName.get(superhero));
                    }
                            }
                            break;*/

                        //TODO Afslutter program
                case 9:
                            System.out.println("We hope to see you again soon");
                            break;

                    }

            }
        }
    }


