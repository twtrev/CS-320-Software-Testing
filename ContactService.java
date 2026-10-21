import java.util.ArrayList;
import java.util.List;

public class ContactService {

    private final List<Contact> contacts = new ArrayList<>();

    // Adds a new contact as long as the contact ID is unique
    public void addContact(Contact contact) {
        for (Contact existingContact : contacts) {
            if (existingContact.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists");
            }
        }

        contacts.add(contact);
    }

    // Deletes a contact using the contact ID
    public void deleteContact(String contactId) {
        Contact contactToDelete = findContact(contactId);

        if (contactToDelete == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contacts.remove(contactToDelete);
    }

    // Updates a contact using the contact ID
    public void updateContact(String contactId, String firstName,
            String lastName, String phone, String address) {

        Contact contactToUpdate = findContact(contactId);

        if (contactToUpdate == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }

        contactToUpdate.setFirstName(firstName);
        contactToUpdate.setLastName(lastName);
        contactToUpdate.setPhone(phone);
        contactToUpdate.setAddress(address);
    }

    // Finds a contact using the contact ID
    public Contact findContact(String contactId) {
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }

        return null;
    }
}
