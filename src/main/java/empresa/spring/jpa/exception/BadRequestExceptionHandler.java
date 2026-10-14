package empresa.spring.jpa.exception;

public class BadRequestExceptionHandler extends RuntimeException {

    public BadRequestExceptionHandler() {
        super("Bad Request!");
    }

    public BadRequestExceptionHandler(String message) {
        super(message);
    }
}
