package domainmodel.comparators;

import domainmodel.Superhero;

import java.util.Comparator;

public class ComparatorAbilities implements Comparator<Superhero> {


    @Override
    public int compare(Superhero otherAbilities1, Superhero otherAbilities2) {
        return otherAbilities1.getAbilities().compareTo(otherAbilities2.getAbilities());
    }
}
