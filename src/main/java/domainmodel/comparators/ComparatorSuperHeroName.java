package domainmodel.comparators;

import domainmodel.Superhero;

import java.util.Comparator;

public class ComparatorSuperHeroName implements Comparator<Superhero> {

    @Override
    public int compare(Superhero otherSuperHero1, Superhero otherSuperHero2) {
        return otherSuperHero1.getSuperheroName().compareTo(otherSuperHero2.getSuperheroName());
    }
}
