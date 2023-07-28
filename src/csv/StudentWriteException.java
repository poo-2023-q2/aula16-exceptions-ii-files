package csv;

/**
 * Excecao checada para sinalizar erros de escrita no arquivo CSV.
 */
public class StudentWriteException extends Exception {
    public StudentWriteException(String message, Throwable e) {
        super(message, e);
    }
}
