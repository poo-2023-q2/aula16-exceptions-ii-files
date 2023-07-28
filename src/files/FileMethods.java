package files;
import java.io.File;

/**
 * A classe File possui um conjunto de metodos que permite
 * obter diversas informacoes de um arquivo.
 */
public class FileMethods {
    public static void main(String[] args) {
        File file = new File("data/test.txt");

        System.out.println("Exists? " + file.exists());
        System.out.println("Size (B): " + file.length());
        System.out.println("Can read? " + file.canRead());
        System.out.println("Can write? " + file.canWrite());
        System.out.println("Can execute? " + file.canExecute());
        System.out.println("Is file? " + file.isFile());
        System.out.println("Is directory? " + file.isDirectory());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("And so on...");
    }
}
