import domainmodel.Database;
import domainmodel.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    Database superheroes;

    @BeforeEach
    void setUp() {
        superheroes = new Database();
    }

    @Test
    void testSUPERHERO_LIST_SIZE() {
        int expectedDBSize = 6;
        int actualSize = superheroes.getAll().size();
        assertEquals(expectedDBSize, actualSize);
    }
    
    @Test
    void testADD_SUPERHERO() {
        int expectedSize = 7;
        superheroes.addSuperhero("Mouse", "Mickey", " MouseMMouse", "Flight", "Human");

        assertEquals(expectedSize, superheroes.getAll().size());
    }

    @Test
    void testDELETE_SUPERHERO () {
        int expected = 5;
        superheroes.deleteSuperhero("Superman");
        assertEquals(expected, superheroes.getAll().size());
    }

    }
