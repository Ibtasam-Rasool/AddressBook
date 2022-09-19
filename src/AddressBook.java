import java.util.*;

public class AddressBook {
    ArrayList<BuddyInfo> buddyList;

    public AddressBook(){
        buddyList = new ArrayList<BuddyInfo>();
        BuddyInfo mahad = new BuddyInfo("Mahad", "Atlanta", "4333321326");
        BuddyInfo ks = new BuddyInfo("slime", "J", "232342354345");

        buddyList.add(mahad);
        buddyList.add(ks);
    }

    public void addBuddy(BuddyInfo newBuddy){
        buddyList.add(newBuddy);
    }

    public void removeBuddy(BuddyInfo noBuddy){
        buddyList.removeIf(buddy -> buddy.getName().equals(noBuddy.getName()));
    }

    public static void main(String[] args) {
        BuddyInfo newBuddy = new BuddyInfo("Brun", "Colonel By", "3213324454");
        AddressBook book = new AddressBook();
        book.addBuddy(newBuddy);
        book.removeBuddy(newBuddy);
    }





}
