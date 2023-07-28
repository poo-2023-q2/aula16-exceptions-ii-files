package csv;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe utilitaria que serializa uma lista de estudantes
 * para um arquivo CSV.
 */
public class StudentCSVWriter {
    private final String fileName;
    private final String separator;

    /**
     * Construtor.
     * 
     * @param filename o nome do arquivo CSV
     * @param separator o separator usado no arquivo
     */
    public StudentCSVWriter(String filename, String separator) {
        this.fileName = filename;
        this.separator = separator;
    }

    /**
     * Concatena a serializacao de um unico estudante no arquivo CSV.
     * 
     * @param student o estudante
     * @throws StudentWriteException caso tenha ocorrido problema na escrita do arquivo
     */
    public void write(Student student) throws StudentWriteException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(student.toCSV(separator));
        } catch (FileNotFoundException e) {
            throw new StudentWriteException("Could not find the alunos file. ", e);
        } catch (IOException e) {
            throw new StudentWriteException("Could not write to the alunos file. ", e);
        }
    }

    /**
     * Serializa uma lista de estudantes para um arquivo CSV.
     * 
     * @param students o array de estudantes
     * @throws StudentWriteException caso tenha ocorrido algum problema na serializacao
     */
    public void writeAll(Student[] students) throws StudentWriteException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
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
