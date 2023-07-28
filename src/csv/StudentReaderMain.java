package csv;

/**
 * Teste de deserializacao de um arquivo CSV de estudantes.
 */
public class StudentReaderMain {

    public static void main(String[] args) {
        
        try {
            StudentCSVReader reader = new StudentCSVReader(args[0], ";");

            for (Student student: reader.readAll()) {
                System.out.println(student);
            }
        } catch (StudentReadException e) {
            // log para o desenvolvedor
            e.printStackTrace(System.err);
            // mensagem amigave para o usuario
            System.out.println("Nao foi possivel ler o arquivo ");
        } catch(ArrayIndexOutOfBoundsException e) {
            e.printStackTrace(System.err);
            System.out.println("Uso: StudentReaderMain <arquivo csv>");
        }
    }
}
