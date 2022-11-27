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

        JMenu fileMenu = new JMenu("File");
        JMenu addressBookMenu = new JMenu("Address Book");
        JMenu buddyInfoMenu = new JMenu("Buddy Info");

        menuBar.add(fileMenu);
        menuBar.add(addressBookMenu);
        menuBar.add(buddyInfoMenu);


        JMenuItem exportOption = new JMenuItem("Export");
        JMenuItem importOption = new JMenuItem("Import");
        JMenuItem removeOption = new JMenuItem("Remove Selected Buddy");
        JMenuItem addBuddy = new JMenuItem("Add Buddy");
        JMenuItem viewBuddy = new JMenuItem("View Selected Buddy Info");

        addressBookMenu.add(removeOption);
        addressBookMenu.add(viewBuddy);
        buddyInfoMenu.add(addBuddy);
        fileMenu.add(exportOption);
        fileMenu.add(importOption);

        buddyInfoJList.addListSelectionListener(e -> addressBook.setSelectedBuddyInfo(buddyInfoJList.getSelectedValue()));
        removeOption.addActionListener(e -> addressBook.removeBuddy());
        viewBuddy.addActionListener(e -> {
            if(addressBook.getSelectedBuddy() != null){
                BuddyInfo buddy = addressBook.getSelectedBuddy();
                JOptionPane.showMessageDialog(this,"NAME: " + buddy.getName() + "\nADDRESS: " + buddy.getAddress() + "\nPHONE: " + buddy.getPhone(),buddy.getName() + "'s information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
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
        exportOption.addActionListener(e -> {

            try {
                addressBook.save(JOptionPane.showInputDialog(this, "Please Enter FileName"));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }


        });
        importOption.addActionListener(e -> {
            String fileName = (JOptionPane.showInputDialog(this, "Please Enter FileName To Import From"));
            try {
                addressBook.makeCurrentImported(AddressBook.importAddressBook(fileName));
            } catch (Exception ex) {
                throw new RuntimeException(ex);
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
