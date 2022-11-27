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

    @Override
    public String toString() {
        return getName();
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
