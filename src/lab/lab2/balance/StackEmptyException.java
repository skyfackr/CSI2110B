package lab.lab2.balance;

public class StackEmptyException extends RuntimeException {
    public StackEmptyException(String err) {
        super(err);
    }
}