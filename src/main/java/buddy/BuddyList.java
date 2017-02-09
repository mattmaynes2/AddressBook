package buddy;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mattmaynes on 1/26/2017.
 */

public class BuddyList extends JList<String> {

    private AddressBook book;

    public BuddyList () {
        super();
        this.setBackground(Color.WHITE);
        this.book = new AddressBook();
        this.setModel(new DefaultListModel<String>());
    }

    public AddressBook getBook () {
        return this.book;
    }

    public void addContact (BuddyInfo info) {
        this.book.addContact(info);
        this.updateBook(this.book);
    }

    public void updateBook (AddressBook book) {
        DefaultListModel<String> model = new DefaultListModel<String>();

        this.book = book;
        this.book.getContacts().forEach((BuddyInfo buddy) -> {
            model.addElement(buddy.toString());
        });
        this.setModel(model);
    }
}
