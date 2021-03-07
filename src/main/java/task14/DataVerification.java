package task14;

public final class DataVerification {
    private static final String namePattern = "[A-Z][a-z]+";
    private static final String fullNamePattern = "[A-Z][a-z]+";
    private static final String emailAddressPattern = "[0-9a-zA-Z][\\dA-z-_.]+@([A-z\\d][A-z\\d-]+\\.){1,6}([A-z]{2,6})$";
    private static final String phoneNumberPattern = "\\d{3}\\s?\\d{3}\\s?\\d{3}\\s?";

    private DataVerification() {

    }

    public static boolean verifyName(String text) {
        return text.matches(namePattern);
    }

    public static boolean verifyFullName(String text) {
        return text.matches(fullNamePattern);
    }

    public static boolean verifyEmail(String text) {
        return text.matches(emailAddressPattern);
    }

    public static boolean verifyPhone(String text) {
        return text.matches(phoneNumberPattern);
    }
}
