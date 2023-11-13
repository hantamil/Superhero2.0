package domainmodel.comparators;

import domainmodel.Superhero;

import java.util.Comparator;

public class ComparatorLastName implements Comparator<Superhero> {
    @Override
    public int compare(Superhero otherLastName1, Superhero otherLastName2) {
        return otherLastName1.getLastName().compareTo(otherLastName2.getLastName());
    }
}
