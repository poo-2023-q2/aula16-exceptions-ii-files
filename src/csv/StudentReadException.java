package csv;

/**
 * Excecao checada para sinalizar erros de leitura no arquivo CSV.
 * 
 */
public class StudentReadException extends Exception {
    public StudentReadException(String message, Throwable e) {
        super(message, e);
    }
}
