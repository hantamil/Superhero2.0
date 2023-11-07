package datasource;
import domainmodel.Superhero;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final File file = new File("superhero.txt");

    public ArrayList<Superhero> loadData (){
        ArrayList<Superhero> superheroList = new ArrayList();
        Scanner sc = null;
        try {
            sc = new Scanner(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Superhero superheroes = null;
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] attributes = line.split(",");
            superheroes = new Superhero(
                    attributes[0],
                    attributes[1],
                    attributes[2],
                    attributes[3],
                    attributes[4]
            );

            superheroList.add(superheroes);
        }

        sc.close();
        return superheroList;
    }
}
