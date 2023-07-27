public class StudentWriterMain {

    public static Student[] makeStudents() {
        return new Student[] {
                new Student("Joao", " Silva", 10.0),
                new Student("Mariana", "Ribeito", 9.9),
                new Student("Francisco", "Dornelles", 5.1),
                new Student("Rebeca", "Ortega", 2.2)
        };
    }

    /**
     * Test client
     * @param args the arguments
     */
    public static void main(String[] args) {
        

        try {
            StudentCSVWriter studentCSVWriter = new StudentCSVWriter(args[0], ";");

            studentCSVWriter.writeAll(makeStudents());
            studentCSVWriter.write(new Student("Caio", "Abreu", 7.4));
        } catch (StudentWriteException e) {
            // log desenvolvedor
            e.printStackTrace(System.err);
            // mensagem amigavel para o usuario
            System.out.println("Nao foi possivel ler o arquivo");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("USo: StudentWriterMain <arquivo csv>");
        } finally {
            System.out.println("File written successfully");
        }
        
    }
}
