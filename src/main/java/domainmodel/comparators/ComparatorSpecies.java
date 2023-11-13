package domainmodel.comparators;

import domainmodel.Superhero;

import java.util.Comparator;

public class ComparatorSpecies implements Comparator<Superhero> {
    @Override
    public int compare(Superhero otherSpecies1, Superhero otherSpecies2) {
        return otherSpecies1.getSpecies().compareTo(otherSpecies2.getSpecies());
    }
}
