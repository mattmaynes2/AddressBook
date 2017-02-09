package buddy; /**
 * Created by mattmaynes on 1/12/2017.
 */

import org.springframework.stereotype.Component;

import javax.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
@Component
public class AddressBook {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> contacts;

    public AddressBook () {
        this.contacts = new ArrayList<BuddyInfo>();
    }

    public void addContact (BuddyInfo contact) {
        this.contacts.add(contact);
    }

    public void removeContact (BuddyInfo contact) { this.contacts.remove(contact); }
    public void removeContact (int index) {this.contacts.remove(index);}

    public List<BuddyInfo> getContacts () {
        return this.contacts;
    }

    public String toString () {
        StringBuffer buff = new StringBuffer();
        for (BuddyInfo buddy : this.contacts) {
            buff.append(buddy.toString() + "\n");
        }
        return buff.toString();
    }

    public boolean equals (Object other) {
        if (other instanceof AddressBook) {
            AddressBook book = (AddressBook) other;
            if (book.contacts.size() != this.contacts.size()) {
                return false;
            }
            for (int i = 0; i < book.contacts.size(); i++) {
                if (!book.contacts.get(i).equals(this.contacts.get(i))) {
                    return false;
                }
            }
            return true;

        }
        return false;
    }
}
