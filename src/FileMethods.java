import java.io.File;

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
