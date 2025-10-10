package aulas.classes.socials;

import java.util.Comparator;
import java.util.Vector;

public class Group {
    private Vector<Contact> contacts;

    public Group(){
        contacts = new Vector<Contact>();
    }

    public void addContact(Contact contact){
        this.contacts.add(contact);
    }

    public Contact[] toArray(){
        return (Contact[]) contacts.toArray();
    }

    public void sort(Comparator<Contact> cmp){
        contacts.sort(cmp);
    }
}
