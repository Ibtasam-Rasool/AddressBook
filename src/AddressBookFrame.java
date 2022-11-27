import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.awt.*;

public class AddressBookFrame extends JFrame implements ListDataListener {

    public AddressBookFrame (){

        super("Address Book");
        AddressBook addressBook = new AddressBook();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JList<BuddyInfo> buddyInfoJList = new JList<>(addressBook);
        this.add(buddyInfoJList);
        this.add(new JScrollPane(buddyInfoJList));
        buddyInfoJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addressBook.addListDataListener(this);

        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        JMenu addressBookMenu = new JMenu("Address Book");
        JMenu buddyInfoMenu = new JMenu("Buddy Info");

        menuBar.add(addressBookMenu);
        menuBar.add(buddyInfoMenu);

        JMenuItem removeOption = new JMenuItem("REMOVE SELECTED BUDDY");
        JMenuItem addBuddy = new JMenuItem("ADD BUDDY");
        addressBookMenu.add(removeOption);
        buddyInfoMenu.add(addBuddy);

        buddyInfoJList.addListSelectionListener(e -> addressBook.setSelectedBuddyInfo(buddyInfoJList.getSelectedValue()));
        removeOption.addActionListener(e -> addressBook.removeBuddy());
        addBuddy.addActionListener(e -> {

            JTextField nameField = new JTextField();
            JTextField addressField = new JTextField();
            JTextField phoneField = new JTextField();

            JPanel myPanel = new JPanel();

            myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

            myPanel.add(new JLabel("Enter Name:"));
            myPanel.add(nameField);

            myPanel.add(new JLabel("Enter Address:"));
            myPanel.add(addressField);

            myPanel.add(new JLabel("Enter Phone:"));
            myPanel.add(phoneField);


            int result = JOptionPane.showConfirmDialog(this, myPanel, "Please Enter Info", JOptionPane.OK_CANCEL_OPTION);

            if(result == JOptionPane.OK_OPTION){
                BuddyInfo buddy = new BuddyInfo(nameField.getText(), addressField.getText(), phoneField.getText());
                addressBook.addBuddy(buddy);
            }

        });

        this.setSize(400, 400);
        this.setVisible(true);

    }


    public static void main(String[] args) {
        AddressBookFrame addressBookFrame = new AddressBookFrame();

    }

    @Override
    public void intervalAdded(ListDataEvent e) {


    }

    @Override
    public void intervalRemoved(ListDataEvent e) {

    }

    @Override
    public void contentsChanged(ListDataEvent e) {

    }
}
