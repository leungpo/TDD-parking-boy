package parking;

public class IncorrectReceiptException extends RuntimeException {
    public IncorrectReceiptException() {
        super("Incorrect Receipt");
    }

}
