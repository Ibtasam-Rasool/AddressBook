import java.util.Scanner;

public class BuddyInfo {

    private String name;
    private String address;
    private String number;


    public BuddyInfo() {
        name = "Ameen";
        address = "Mesdjal Belhease";
        number = "613-733-1022";
    }

    public BuddyInfo(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    public static BuddyInfo importBuddyInfo(String buddyInfoString){
        Scanner s = new Scanner(buddyInfoString).useDelimiter("#");
        return new BuddyInfo(s.next(), s.next(), s.next());

    }


    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object obj) {
        BuddyInfo buddyInfo = (BuddyInfo) obj;
        if(buddyInfo.getAddress().equals(address) && buddyInfo.getName().equals(name) && buddyInfo.getPhone().equals(number)){

            return true;

        }
        return false;
    }



    public String toOutPutString() {
        return getName() + "#" + getAddress() + "#" + getPhone();
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return number;
    }

    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("Nabeel Hesa", "None", "None");
        System.out.println("Hello" + " " + buddy.getName());

    }

}
