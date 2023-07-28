package csv;
import java.util.Locale;

/**
 * Um simples objeto imutável que pode ser serializado 
 * em CSV.
 */
public class Student {
    private final String firstName;
    private final String lastName;
    private final double grade;

    public Student(String firstName, String lastName, double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    /**
     * Serializa o objeto no formato CSV.
     *
     * @param separator o separator do formato
     * @return uma string contendo a serializacao
     */
    public String toCSV(String separator) {
        return String.join(separator, firstName, lastName, 
            String.format(Locale.US, "%.3f", grade)) + "\n";
    }

    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n"
                + String.format("Grade: %.3f\n", grade);
    }
}
