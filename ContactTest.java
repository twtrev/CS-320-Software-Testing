import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContactCreation() {
        Contact contact = new Contact(
                "12345",
                "Trevor",
                "Williams",
                "5085551234",
                "123 Main Street");

        assertEquals("12345", contact.getContactId());
        assertEquals("Trevor", contact.getFirstName());
        assertEquals("Williams", contact.getLastName());
        assertEquals("5085551234", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "Trevor", "Williams",
                    "5085551234", "123 Main Street");
        });
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Trevor", "Williams",
                    "5085551234", "123 Main Street");
        });
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Trevorrrrrr", "Williams",
                    "5085551234", "123 Main Street");
        });
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Williams",
                    "5085551234", "123 Main Street");
        });
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Trevor", "Williamssss",
                    "5085551234", "123 Main Street");
        });
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Trevor", null,
                    "5085551234", "123 Main Street");
        });
    }

    @Test
    void testPhoneNotTenDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Trevor", "Williams",
                    "508555123", "123 Main Street");
        });
    }

    @Test
    void testPhoneContainsLetters() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Trevor", "Williams",
                    "50855abc34", "123 Main Street");
        });
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Trevor", "Williams",
                    null, "123 Main Street");
        });
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Trevor", "Williams",
                    "5085551234",
                    "1234567890123456789012345678901");
        });
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Trevor", "Williams",
                    "5085551234", null);
        });
    }
}