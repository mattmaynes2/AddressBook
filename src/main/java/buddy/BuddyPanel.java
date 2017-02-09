package buddy;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mattmaynes on 1/26/2017.
 */
public class BuddyPanel extends JPanel {

    private JTextField nameField;
    private JTextField phoneField;

    public BuddyPanel () {
        super();
        this.setSize(300, 100);
        this.nameField = new JTextField();
        this.phoneField = new JTextField();
        this.setLayout(new GridLayout(2, 2));
    }

    public void init () {
        this.add(new JLabel("Name: "));
        this.add(this.nameField);
        this.add(new JLabel("Phone: "));
        this.add(this.phoneField);
    }

    public void showContact(BuddyInfo source) {
        this.nameField.setText(source.getName());
        this.phoneField.setText(source.getPhoneNumber());
    }

    public BuddyInfo createContact () {
        BuddyInfo info = new BuddyInfo();
        info.setName(this.nameField.getText());
        info.setPhoneNumber(this.phoneField.getText());
        return info;
    }

}
