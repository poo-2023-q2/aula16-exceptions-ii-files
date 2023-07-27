import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class that writes a student object to a file
 */
public class StudentCSVWriter {
    private final String fileName;
    private final String separator;

    public StudentCSVWriter(String filename, String separator) {
        this.fileName = filename;
        this.separator = separator;
    }

    public void write(Student student) throws StudentWriteException {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(student.toCSV(separator));
        } catch (FileNotFoundException e) {
            throw new StudentWriteException("Could not find the alunos file. ", e);
        } catch (IOException e) {
            throw new StudentWriteException("Could not write to the alunos file. ", e);
        }
    }

    public void writeAll(Student[] students) throws StudentWriteException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Student student : students) {
                writer.write(student.toCSV(separator));
            }
        } catch (FileNotFoundException e) {
            throw new StudentWriteException("Could not find the alunos file. ", e);
        } catch (IOException e) {
            throw new StudentWriteException("Could not write to the alunos file. ", e);
        }
    }
}
