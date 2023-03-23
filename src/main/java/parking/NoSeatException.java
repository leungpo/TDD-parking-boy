package parking;

public class NoSeatException extends RuntimeException {
    public NoSeatException() {
        super("No Seat");
    }
}
