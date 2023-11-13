import domainmodel.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void testDELETE_SUPERHERO() {
        //Arrange
        
        //Act
        //Assert
    }

}
