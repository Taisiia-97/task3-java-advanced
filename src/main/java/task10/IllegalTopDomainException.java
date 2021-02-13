package task10;

import java.security.PrivilegedExceptionAction;

public class IllegalTopDomainException extends Exception {
    public IllegalTopDomainException() {
    }

    public IllegalTopDomainException(String message) {
        super(message);
    }
}
