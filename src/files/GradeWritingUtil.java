package files;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Exemplo de como escrever em um arquivo utilizando a classe PrintWriter.
 */
public class GradeWritingUtil {
    public static void main(String[] args) {

        try (PrintWriter pw = new PrintWriter(new File("data/notas.csv"))) {
            String format = "%s %.3f\n";

            pw.printf(format, "Joao Silva", 10.0);
            pw.printf(format, "Mariana Ribeito", 9.9);
            pw.printf(format, "Francisco Dornelles", 5.1);
            pw.printf(format, "Rebeca Ortega", 2.2);
        } catch (FileNotFoundException e) {
            System.err.println("Failed to create the file to write. " + e.getMessage());
        }


    }
}
