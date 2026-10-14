package empresa.spring.jpa.exception;

public class ResouceExceptionHandler extends RuntimeException {


    public ResouceExceptionHandler() {
        super("Not found!");
    }

    public ResouceExceptionHandler(String message) {
        super(message);
    }
}
