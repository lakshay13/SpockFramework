package spockbasics.exceptions;

/**
 * Created by lakshay on 27/11/16.
 */
public class NumberFormatException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     */
    public NumberFormatException(String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     */
    public NumberFormatException(String message, Throwable cause) {
        super(message, cause);
    }

}
