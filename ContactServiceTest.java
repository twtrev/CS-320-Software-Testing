import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345",
                "Trevor",
                "Williams",
                "5085551234",
                "123 Main Street");

        service.addContact(contact);

        assertEquals(contact, service.findContact("12345"));
    }

    @Test
    void testAddDuplicateContact() {
        ContactService service = new ContactService();

        Contact contact1 = new Contact(
                "12345",
                "Trevor",
                "Williams",
                "5085551234",
                "123 Main Street");

        Contact contact2 = new Contact(
                "12345",
                "John",
                "Smith",
                "5085555678",
                "456 Main Street");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345",
                "Trevor",
                "Williams",
                "5085551234",
                "123 Main Street");

        service.addContact(contact);
        service.deleteContact("12345");

        assertNull(service.findContact("12345"));
    }

    @Test
    void testDeleteContactNotFound() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("12345");
        });
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact(
                "12345",
                "Trevor",
                "Williams",
                "5085551234",
                "123 Main Street");

        service.addContact(contact);

        service.updateContact(
                "12345",
                "John",
                "Smith",
                "5085555678",
                "456 Main Street");

        Contact updatedContact = service.findContact("12345");

        assertEquals("John", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("5085555678", updatedContact.getPhone());
        assertEquals("456 Main Street", updatedContact.getAddress());
    }

    @Test
    void testUpdateContactNotFound() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact(
                    "99999",
                    "John",
                    "Smith",
                    "5085555678",
                    "456 Main Street");
        });
    }
}