package task10;

public class IllegalUsernameException extends Exception{
    public IllegalUsernameException() {
    }

    public IllegalUsernameException(String message) {
        super(message);
    }
}
