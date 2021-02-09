package task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailAddress {
    private static final String pattern ="[0-9a-zA-Z][\\dA-z-_.]+@([A-z\\d][A-z\\d-]+\\.){1,6}([A-z]{2,6})$";
    private String email;

    private EmailAddress(String email) {
        this.email = email;

    }

    public static EmailAddress of(String email) {
        if (Pattern.matches(pattern, email)) return new EmailAddress(email);
        return null;
    }

    public String getEmail() {
        return email;
    }

    public String userName() {
        return email.substring(0, email.indexOf("@"));
    }

    public String host() {
        return email.substring(email.indexOf("@") + 1);
    }

    public String topDomain() {
        return email.substring(email.lastIndexOf('.')+1);
    }
}
