package ex05;

public class UserNotFoundException extends RuntimeException {

    @Override
    public String toString() {
        return ("User not found");
    }
}
