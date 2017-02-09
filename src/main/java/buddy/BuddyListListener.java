package buddy;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by mattmaynes on 1/26/2017.
 */
public class BuddyListListener implements ListSelectionListener {

    private BuddyPanel panel;

    public BuddyListListener (BuddyPanel panel) {
        this.panel = panel;
    }

    public void valueChanged(ListSelectionEvent event) {
        BuddyList list = (BuddyList) event.getSource();
        int index = list.getSelectedIndex();

        if (index >= 0) {
            panel.showContact(list.getBook().getContacts().get(list.getSelectedIndex()));

        }
    }
}
