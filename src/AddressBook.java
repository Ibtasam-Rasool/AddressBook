import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;

public class AddressBook extends DefaultListModel<BuddyInfo> implements Serializable {

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

    public BuddyInfo getSelectedBuddy(){
        if(isBuddySelected) {
            return selectedBuddyInfo;
        }
        return null;
    }

    public void setSelectedBuddyInfo(BuddyInfo buddy){
        selectedBuddyInfo = buddy;
        isBuddySelected = true;
    }

    public void save(String fileName) throws Exception{     //for text file

        FileWriter writer = new FileWriter(fileName);
        BufferedWriter p = new BufferedWriter(writer);

        for(int i = 0; i < this.getSize(); i++){
            p.write(this.getElementAt(i).toOutPutString());
            p.write('\n');
        }
        p.close();
    }

    public static void writeObject(AddressBook addressBook, String fileName) throws Exception{      //for serialization

        FileOutputStream os = new FileOutputStream(fileName);

        ObjectOutputStream oos = new ObjectOutputStream(os);

        oos.writeObject(addressBook);

        oos.flush();
        os.close();


    }

    public static AddressBook readObject(String fileName) throws Exception{     //for serialization

        FileInputStream fis = new FileInputStream(fileName);

        ObjectInputStream ois = new ObjectInputStream(fis);

        AddressBook addressBook;

        addressBook = (AddressBook) ois.readObject();

        fis.close();

        return addressBook;

    }

    public static AddressBook importAddressBook(String fileName) throws Exception {     // for text file
        AddressBook addressBook = new AddressBook();
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String strCurrentLine;

        while ((strCurrentLine = in.readLine()) != null) {
            addressBook.addElement(BuddyInfo.importBuddyInfo(strCurrentLine));
        }

        return addressBook;

    }

    @Override
    public boolean equals(Object obj) {
        AddressBook addressBook = (AddressBook) obj;

        if(!(this.size() == addressBook.size())){
            return false;
        };

        for(int i = 0; i < this.size(); i++){

            if (!(addressBook.getElementAt(i).equals(this.getElementAt(i)))){
                return false;
            }

        }
        return true;
    }

    public void makeCurrentImported(AddressBook addressBook){
        this.clear();
        for(int i = 0; i < addressBook.size(); i++){
            this.addElement(addressBook.getElementAt(i));
        }

    }





    public static void main(String[] args) {

        /*

        AddressBook book = new AddressBook();
        BuddyInfo mahad = new BuddyInfo("Mahad", "Atlanta", "4333321326");
        BuddyInfo mahad2 = new BuddyInfo("Mahad", "Atlanta", "4333321326");
        BuddyInfo mahad3 = new BuddyInfo("Mahad", "Atlanta", "4333321326");
        book.addBuddy(mahad);
        book.addBuddy(mahad2);
        book.addBuddy(mahad3);
        try {
            book.save("info.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        AddressBook book2;
        try {
            book2 = AddressBook.importAddressBook("info.txt");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(book2);


        BuddyInfo info = BuddyInfo.importBuddyInfo("Mahad#Atlanta#4333321326");
        System.out.println(info.getName());
        System.out.println(info.getAddress());
        System.out.println(info.getPhone());
         */

        AddressBook book = new AddressBook();
        BuddyInfo mahad = new BuddyInfo("Mahad", "Atlanta", "4333321326");
        BuddyInfo mahad2 = new BuddyInfo("Mahad", "Atlanta", "4333321326");
        BuddyInfo mahad3 = new BuddyInfo("Mahad", "Atlanta", "4333321326");
        book.addBuddy(mahad);
        book.addBuddy(mahad2);
        book.addBuddy(mahad3);

        try {
            AddressBook.writeObject(book,"test.bin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            AddressBook addressBook = AddressBook.readObject("test.bin");
            System.out.println(addressBook.getElementAt(0).getPhone());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }








    }





}
