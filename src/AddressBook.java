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

    public void addBuddy(String name, String address, String number){
        BuddyInfo newBuddy = new BuddyInfo(name, address, number);
        buddyList.add(newBuddy);
    }

    public void removeBuddy(String name){
        buddyList.removeIf(buddy -> buddy.getName().equals(name));
    }

    public static void main(String[] args) {
        System.out.println("Address Book");
    }





}
