package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class PhoneTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Phone(null));
    }

    @Test
    public void constructor_invalidPhone_throwsIllegalArgumentException() {
        String invalidPhone = "";
        assertThrows(IllegalArgumentException.class, () -> new Phone(invalidPhone));
    }

    @Test
    public void isValidPhone() {
        // null phone number
        assertThrows(NullPointerException.class, () -> Phone.isValidPhone(null));

        // invalid phone numbers
        assertFalse(Phone.isValidPhone("")); // empty string
        assertFalse(Phone.isValidPhone(" ")); // spaces only
        assertFalse(Phone.isValidPhone("915789")); // less than 7 numbers
        assertFalse(Phone.isValidPhone("1234567890123456")); // more than 15 numbers
        assertFalse(Phone.isValidPhone("1234--5678")); // consecutive hyphens
        assertFalse(Phone.isValidPhone("phone")); // non-numeric
        assertFalse(Phone.isValidPhone("9011p041")); // alphabets within digits
        assertFalse(Phone.isValidPhone("9312 1534")); // spaces within digits

        // valid phone numbers
        assertTrue(Phone.isValidPhone("1234567")); // exactly 7 digits
        assertTrue(Phone.isValidPhone("123456789012345")); // exactly 15 digits
        assertTrue(Phone.isValidPhone("+93121534")); // with leading plus sign
        assertTrue(Phone.isValidPhone("123-456-789")); // with hyphens
    }

    @Test
    public void equals() {
        Phone phone = new Phone("12345678");

        // same values -> returns true
        assertTrue(phone.equals(new Phone("12345678")));

        // same object -> returns true
        assertTrue(phone.equals(phone));

        // null -> returns false
        assertFalse(phone.equals(null));

        // different types -> returns false
        assertFalse(phone.equals(5.0f));

        // different values -> returns false
        assertFalse(phone.equals(new Phone("12345679")));
    }
}
