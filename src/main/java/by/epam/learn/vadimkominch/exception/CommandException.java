package by.epam.learn.vadimkominch.exception;

public class CommandException extends Exception {
    private static final long serialVersionUID = 576339038821832653L;

    public CommandException() {
        super();
    }

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommandException(Throwable cause) {
        super(cause);
    }
}
