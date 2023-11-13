package ui;
import controller.Controller;
import domainmodel.Superhero;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static final String CYAN = "\033[0;36m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String RESET = "\033[0m";
    public static final String BLACK_BOLD = "\033[1;30m";


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
        Scanner keyboard = new Scanner(System.in);

        System.out.println(CYAN_BOLD + "\nWelcome to the SUPERHERO UNIVERSE!" + RESET);
        boolean runProgram = true;

        while (runProgram) {
            int menuNumber;

            System.out.println(CYAN + "\u2501".repeat(80) + RESET);
            System.out.println("Choose your next step and enter a number:");
            System.out.println("1. " + CYAN + "Create" + RESET);
            System.out.println("2. " + CYAN + "See complete list of superheroes" + RESET);
            System.out.println("3. " + CYAN + "Search for superhero" + RESET);
            System.out.println("4. " + CYAN + "Edit superhero" + RESET);
            System.out.println("5. " + CYAN + "Delete superhero" + RESET);
            System.out.println("6. " + CYAN + "See complete list of superheroes sorted by an attribute" + RESET);
            System.out.println("7. " + CYAN + "See complete list of superheroes sorted by multiple attributes" + RESET);
            System.out.println("8. " + CYAN + "Close" + RESET);
            System.out.println(CYAN + "\u2501".repeat(80) + RESET);

            menuNumber = scanIntWithRetry();

            switch (menuNumber) {
                //TODO Create, virker
                case 1:
                    System.out.println("\nEnter the superhero details:");
                    System.out.print("Superhero name: ");
                    String superheroName = keyboard.next();
                    System.out.print("Legal name (first and last): ");
                    String firstName = keyboard.next();
                    String lastName = keyboard.next();
                    System.out.print("Superpower: ");
                    String abilities = keyboard.next();
                    System.out.print("Type of creature: ");
                    String species = keyboard.next();
                    System.out.println("\nThe superhero you have added:");
                    System.out.println(CYAN + " Superhero: " + superheroName + RESET);
                    System.out.println(" Name: " + firstName + " " + lastName);
                    System.out.println(" Abilities: " + abilities);
                    System.out.println(" Species: " + species);

                    keyboard.nextLine();
                    controller.addSuperhero(superheroName, firstName, lastName, abilities, species);
                    break;

                //TODO See complete list of Superheroes, virker
                case 2:
                    if (controller.getSuperheroList().isEmpty()) {
                        System.out.println("No superheroes found");
                    } else {
                        System.out.println("\nComplete list of superheroes:");
                        for (Superhero superhero1 : controller.getSuperheroList()) {
                            if (superhero1 != null)
                                System.out.println(CYAN + "\n Superhero: " + superhero1.getSuperheroName() + RESET +
                                        "\n Name: " + superhero1.getFirstName() + " " + superhero1.getLastName() +
                                        "\n Abilities: " + superhero1.getAbilities() +
                                        "\n Species: " + superhero1.getSpecies());
                        }
                    }
                    break;

                //TODO Search for Superheroes, virker
                case 3:
                    System.out.print("\nEnter the superhero name: ");
                    superheroName = keyboard.next();

                    ArrayList<Superhero> attributeSearch = controller.findSuperhero(superheroName);

                    if (attributeSearch.isEmpty()) {
                        System.out.println("This superhero does not exist in our library of superheroes.");
                    } else {
                        System.out.println("\nSuperheroes found with the name " + CYAN + superheroName + RESET + ":");
                        for (Superhero name : attributeSearch) {
                            System.out.println(CYAN + " - " + name.getSuperheroName() + RESET);
                        }
                    }
                    break;

                //TODO Edit Superheroes, virker
                case 4:
                    System.out.print("\nEnter the name of the superhero you would like to edit: ");
                    final String searchSHName = keyboard.nextLine();
                    ArrayList<Superhero> searchSHN = controller.findSuperhero(searchSHName);

                    if (!searchSHN.isEmpty()) {
                        System.out.println("\nSuperheroes found with the name " + CYAN + searchSHName + RESET + ":");

                        for (int index = 0; index < searchSHN.size(); index++) {
                            System.out.println(CYAN + " " + (index + 1) + ". " + searchSHN.get(index).getSuperheroName() + RESET);
                        }

                        System.out.print("Type in the number of the superhero you would like to edit: ");
                        int superheroNumber = scanIntWithRetry();
                        Superhero editSuperhero = searchSHN.get(superheroNumber - 1);

                        System.out.println("\nEdit the data and press ENTER. If the data does not require changes, press ENTER.");

                        System.out.print("Superhero Name: " + editSuperhero.getSuperheroName() + " -> ");
                        String newSuperheroName = keyboard.nextLine();
                        if (!newSuperheroName.isEmpty())
                            editSuperhero.setSuperheroName(newSuperheroName);

                        System.out.print("First name: " + editSuperhero.getFirstName() + " -> ");
                        String newFirstName = keyboard.nextLine();
                        if (!newFirstName.isEmpty())
                            editSuperhero.setFirstName(newFirstName);

                        System.out.print("Last name: " + editSuperhero.getLastName() + " -> ");
                        String newLastName = keyboard.nextLine();
                        if (!newLastName.isEmpty())
                            editSuperhero.setLastName(newLastName);

                        System.out.print("Abilities: " + editSuperhero.getAbilities() + " -> ");
                        String newAbilities = keyboard.nextLine();
                        if (!newAbilities.isEmpty())
                            editSuperhero.setAbilities(newAbilities);

                        System.out.print("Species: " + editSuperhero.getSpecies() + " -> ");
                        String newSpecies = keyboard.nextLine();
                        if (!newSpecies.isEmpty())
                            editSuperhero.setSpecies(newSpecies);
                    } else {
                        System.out.println("No results match your search: " + searchSHName);
                    }
                    break;

                //TODO Delete Superheroes
                case 5:
                    System.out.print("\nEnter the superhero you want to delete: ");
                    superheroName = keyboard.next();

                    ArrayList<Superhero> superheroDelete = controller.findSuperhero(superheroName);
                    if (superheroDelete.isEmpty()) {
                        System.out.println("This superhero does not exist in our database");
                    } else {
                        controller.deleteSuperhero(superheroName);
                    }

                    break;

                // TODO View sorted
                case 6:
                    System.out.print("\nWhich attribute do you want to sort by: ");
                    String attributeSort = keyboard.nextLine().toLowerCase();

                    if (attributeSort.equalsIgnoreCase("superhero name") || attributeSort.equalsIgnoreCase("first name") || attributeSort.equalsIgnoreCase("last name") || attributeSort.equalsIgnoreCase("abilities") || attributeSort.equalsIgnoreCase("species")) {
                        String sortedSuperheroes = controller.getSortBy(attributeSort);

                        if ("Invalid attribute for sorting.".equals(sortedSuperheroes)) {
                            System.out.println(sortedSuperheroes);
                        } else {
                            System.out.println("\n" + sortedSuperheroes);
                        }
                    } else {
                        System.out.println("Invalid attribute for sorting.");
                    }
                    break;

                // TODO View sorted multiple attributes
                case 7:
                    System.out.println("\nChoose two numbers for the list to be sorted by:");
                    System.out.println("1. Superhero name");
                    System.out.println("2. First name");
                    System.out.println("3. Last name");
                    System.out.println("4. Abilities");
                    System.out.println("5. Species");

                    System.out.print("\nChoose the first attribute: ");
                    String attribute1 = keyboard.nextLine().toLowerCase();

                    System.out.print("\nChoose the second attribute: ");
                    String attribute2 = keyboard.nextLine().toLowerCase();

                    System.out.println(controller.getSortByMultipleAttributes(attribute1, attribute2));
                    break;

                //TODO Afslutter program
                case 8:
                    System.out.println(BLACK_BOLD + "We hope to see you again soon" + RESET);
                    runProgram = false;
                    break;

                default:
                    runProgram = true;
            }
        }
    }
}