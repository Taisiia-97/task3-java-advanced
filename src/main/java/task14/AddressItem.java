package task14;

import java.io.Serializable;
import java.time.LocalDate;

public class AddressItem implements Serializable {
    final String name;
    final String fullName;
    final String emailAddress;
    final String phoneNumber;
    final LocalDate birthDate;
private static final long serialVersionId =  2153163831931434056L;

    public AddressItem(String name, String fullName, String emailAddress, String phoneNumber, LocalDate birthDate) {
        this.name = name;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
