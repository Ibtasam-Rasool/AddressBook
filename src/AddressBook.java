import javax.swing.*;
import java.util.*;

public class AddressBook extends DefaultListModel<BuddyInfo> {

    private BuddyInfo selectedBuddyInfo;
    private boolean isBuddySelected;

    public AddressBook(){
        super();
        isBuddySelected = false;
    }

    public void addBuddy(BuddyInfo newBuddy){
        addElement(newBuddy);
    }

    public void removeBuddy(){

        if(isBuddySelected) {
            removeElement(selectedBuddyInfo);
            isBuddySelected = false;
        }
    }

    public void setSelectedBuddyInfo(BuddyInfo buddy){
        selectedBuddyInfo = buddy;
        isBuddySelected = true;
    }

    public static void main(String[] args) {

        AddressBook book = new AddressBook();
        BuddyInfo mahad = new BuddyInfo("Mahad", "Atlanta", "4333321326");
        book.addBuddy(mahad);
        System.out.println(book);

    }

}
