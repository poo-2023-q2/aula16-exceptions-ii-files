package csv;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;

/**
 * Classe utilitaria que deserializa uma lista de estudantes
 * a partir de um arquivo CSV.
 */
public class StudentCSVReader {
    private String fileName;
    private String separator;

    /**
     * Construtor.
     * 
     * @param fileName o nome do arquivo CSV.
     * @param separator o separator usado no arquivo
     */
    public StudentCSVReader(String fileName, String separator) {
        this.fileName = fileName;
        this.separator = separator;
    }

    /**
     * Conta a quantidade de registros no arquivo (i.e. a quantidade 
     * de linhas nao-vazias).
     * 
     * @return a quantidade
     * @throws StudentReadException caso tenha ocorrido problema na leitura do arquivo
     */
    private int countStudents() throws StudentReadException {
        int qtyStudents = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))) {
            while (reader.ready()) {
                if (reader.readLine().strip().length() > 0) {
                    qtyStudents++;
                }
            }
        } catch (FileNotFoundException e) {
            throw new StudentReadException("Failed to open alunos file", e);
        } catch (IOException e) {
            throw new StudentReadException("Failed to read alunos file ", e);
        }

        return qtyStudents;
    }

    /**
     * Deserializa todos os estudantes presentes no arquivo. 
     * 
     * @return um array de estudantes
     * @throws StudentReadException caso tenha ocorrido erro na leitura do arquivo
     */
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
