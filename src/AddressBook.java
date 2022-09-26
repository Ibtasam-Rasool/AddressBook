import java.util.*;

public class AddressBook {
    ArrayList<BuddyInfo> buddyList;

    public AddressBook(){
        buddyList = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo newBuddy){

        if(newBuddy != null){
            buddyList.add(newBuddy);
        }
    }

    public void removeBuddy(BuddyInfo noBuddy){
        buddyList.removeIf(buddy -> buddy.getName().equals(noBuddy.getName()));
    }

    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        BuddyInfo mahad = new BuddyInfo("Mahad", "Atlanta", "4333321326");
        book.addBuddy(mahad);
        book.removeBuddy(mahad);


    }

}
