package buddy;

import javax.swing.*;
import java.awt.*;


public class AddressFrame extends JFrame {

    private BuddyList buddyList;
    private BuddyPanel buddyPanel;
    private JButton addButton;
    private AddBuddyListener addListener;

    public AddressFrame () {
        super("Address Book");

        this.addButton = new JButton("Add");

        this.setSize(500, 500);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2, 3));
        this.setResizable(false);
    }

    public void init () {

        this.buddyList.addListSelectionListener(new BuddyListListener(this.buddyPanel));
        this.addButton.addActionListener(this.addListener);

        this.add(this.buddyList);
        this.add(this.buddyPanel);
        this.add(this.addButton);
        AddressBook book = new AddressBook();

        this.setBook(book);
        this.setVisible(true);
    }

    public void setBuddyPanel (BuddyPanel panel) {
        this.buddyPanel = panel;
    }

    public void setBuddyList (BuddyList list) {
        this.buddyList = list;
    }

    public void setAddListener (AddBuddyListener listener) {
        this.addListener = listener;
    }

    public void setBook (AddressBook book) {
        this.buddyList.updateBook(book);
    }

}
