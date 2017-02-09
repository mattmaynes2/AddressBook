package buddy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mattmaynes on 1/26/2017.
 */
public class AddBuddyListener implements ActionListener {

    private BuddyList buddyList;
    private BuddyPanel buddyPanel;



    public void actionPerformed (ActionEvent event) {
        this.buddyList.addContact(this.buddyPanel.createContact());
    }

    public void setBuddyList (BuddyList list) {
        this.buddyList = list;
    }

    public void setBuddyPanel (BuddyPanel panel) {
        this.buddyPanel = panel;
    }

}
