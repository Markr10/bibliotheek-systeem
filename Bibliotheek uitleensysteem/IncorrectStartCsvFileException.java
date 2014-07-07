
/**
 * Thrown to indicate that the operation could not complete because of an incorrect start of the CSV file.
 * 
 * @author  Wybren, Danny en Mark
 * @version 7 April 2014
 */
public class IncorrectStartCsvFileException extends Exception
{
    /**
     * Constructs an {@code IncorrectStartCsvFileException} with null as its detail message.
     */
    public IncorrectStartCsvFileException()
    {
        super();
    }

    /**
     * Constructs an {@code IncorrectStartCsvFileException} with the a message that will be incorporated in the message for this exception.
     *
     * @param message The detail message that will be incorporated in the message for this exception.
     */
    public IncorrectStartCsvFileException(String message)
    {
        super("Start of CSV file is not correct! " + message);
    }

    /**
     * Constructs an {@code IncorrectStartCsvFileException} with the a message that will be incorporated in the message for this exception and cause.
     *
     * Note that the detail message associated with {@code cause} is <span style="font-style: italic;">not</span>
     * automatically incorporated in this exception's detail message.
     *
     * @param message The detail message that will be incorporated in the message for this exception.
     * @param cause   The cause. (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public IncorrectStartCsvFileException(String message, Throwable cause)
    {
        super("Start of CSV file is not correct! " + message, cause);
    }

    /**
     * Constructs an {@code IncorrectStartCsvFileException} with the specified cause and a detail message of {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of {@code cause}).
     *
     * @param cause The cause. (A {@code null} value is permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public IncorrectStartCsvFileException(Throwable cause)
    {
        super(cause);
    }
}
