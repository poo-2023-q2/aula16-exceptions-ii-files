import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GradeReadingUtil {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("data/notas.csv"))) {
          while (scanner.hasNext()) {
              System.out.printf("%s %s %.3f \n", 
                scanner.next(), 
                scanner.next(), 
                Double.parseDouble(scanner.next()));
          }
        } catch (FileNotFoundException e) {
            System.err.println("Could not find input file. " + e.getMessage());
        }
    }
}
