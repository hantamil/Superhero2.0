public class Superhero {

    private String superheroName;
    private String firstName;
    private String lastName;
    private String abilities;
    private String species;

    public Superhero(String superheroName, String firstName, String lastName, String abilities, String species){
        this.superheroName = superheroName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.abilities = abilities;
        this.species = species;
    }

    public String getSuperheroName() {
        return superheroName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAbilities() {
        return abilities;
    }

    public String getSpecies() {
        return species;
    }

    public void setSuperheroName(String superheroName) {
        this.superheroName = superheroName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAbilities(String abilities) {
        this.abilities=abilities;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
