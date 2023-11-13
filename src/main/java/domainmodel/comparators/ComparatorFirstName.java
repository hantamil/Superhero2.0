package domainmodel.comparators;

import domainmodel.Superhero;

import java.util.Comparator;

public class ComparatorFirstName implements Comparator<Superhero> {
    @Override
    public int compare(Superhero otherFirstName1, Superhero otherFirstName2) {
        return otherFirstName1.getFirstName().compareTo(otherFirstName2.getFirstName());
    }
}
