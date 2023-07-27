import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudentCSVReader {
    private String fileName;
    private String separator;

    public StudentCSVReader(String fileName, String separator) {
        this.fileName = fileName;
        this.separator = String.format("[%s\n]", separator);
    }

    private int countStudents() throws StudentReadException {
        int qtyStudents = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            while (reader.ready()) {
                qtyStudents++;
                reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new StudentReadException("Failed to open alunos file", e);
        } catch (IOException e) {
            throw new StudentReadException("Failed to read alunos file ", e);
        }

        return qtyStudents;
    }

    public Student[] readAll() throws StudentReadException {
        Student[] students = new Student[countStudents()];

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            for (int i = 0; i < students.length; i++) {
                String[] columns = reader.readLine().split(separator);

                students[i] = new Student(columns[0], 
                    columns[1], 
                    Double.parseDouble(columns[2]));
            }
        } catch (FileNotFoundException e) {
            throw new StudentReadException("Failed to open alunos file. ", e);
        } catch (NumberFormatException e) {
            throw new StudentReadException("Failed to parse a grade. ", e);
        } catch (IOException e) {
            throw new StudentReadException("Failed to read alunos file", e);
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new StudentReadException("Insufficient number of columns", e);
        }

        return students;
    }
}
