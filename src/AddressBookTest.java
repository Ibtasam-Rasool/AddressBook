import org.junit.Before;

import static org.junit.Assert.*;

public class AddressBookTest {

    private AddressBook addressBook;

    @Before
    public void setUp() {
        addressBook = new AddressBook();
        addressBook.addBuddy(new BuddyInfo("Linda J Charles", "1815 Wakefield Street", "215-440-0950"));
        addressBook.addBuddy(new BuddyInfo("Marian J Singh", "203 Maxwell Street", "203-536-9817"));
        addressBook.addBuddy(new BuddyInfo("James M Beggs", "1797 Cook Hill Road", "860-670-3253"));
    }

    @org.junit.Test
    public void importExport() throws Exception{

        String fileName = "buddy_addresses_test.txt";
        addressBook.save(fileName);
        AddressBook addressBook1 = AddressBook.importAddressBook(fileName);

        assertTrue(addressBook1.equals(addressBook));

    }

}