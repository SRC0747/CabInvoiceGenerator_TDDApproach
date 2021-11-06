package cabinvoicegenerator;

/**
 * InvoiceGeneratorException is used  to  check whether the given UserId already exists or not and throws an exception message.
 *
 * @author Sampriti Roy Chowdhury
 * @version 0.0.1
 * @since 7-11-2021
 */

public class InvoiceGeneratorException extends Exception {
    public enum ExceptionType {
        USER_ALREADY_EXISTS
    }
    public ExceptionType type;
    public InvoiceGeneratorException(ExceptionType type, String message)
    {
        super(message);
        this.type = type;
    }
}
