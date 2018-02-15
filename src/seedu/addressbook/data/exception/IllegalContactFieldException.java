package seedu.addressbook.data.exception;

/**
 * Signals that contact field is not any of the possible 4 options.
 */
public class IllegalContactFieldException extends Exception {
    /**
     * @param message should contain relevant information on the failed constraint(s)
     */
    public IllegalContactFieldException(String message) {
        super(message);
    }
}
