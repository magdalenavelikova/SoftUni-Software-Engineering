package designPattern.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class Phonebook {

    private Collection<Contact> contacts;

    public Phonebook() {
        this.contacts = new ArrayList<>();
    }

    public Collection<Contact> getAllContacts() {
        return Collections.unmodifiableCollection(this.contacts);
    }

    public boolean addContact(Contact contact) {
        System.out.println("* " + contact.getName() + " was added to the contact list. *");
        return this.contacts.add(contact);
    }

    public boolean deleteContactByName(String contactName) {
        Contact contact = getContactByName(contactName);
        System.out.println("* " + contact.getName() + " was removed from the contact list. *");
        return this.contacts.remove(contact);
    }

    public Contact getContactByName(String contactName) {
        Optional<Contact> contact = this.getAllContacts()
                .stream()
                .filter(c -> c.getName().equals(contactName))
                .findFirst();

        if (contact.isEmpty()) {
            throw new IllegalArgumentException("Contact does not exist.");
        }

        return contact.get();
    }
}
