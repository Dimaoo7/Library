package pro.sky.librays.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("404 Bad Request");
    }
}