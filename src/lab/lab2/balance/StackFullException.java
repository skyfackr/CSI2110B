package lab.lab2.balance;

public class StackFullException extends RuntimeException {
    public StackFullException(String err) {
        super(err);
    }
}