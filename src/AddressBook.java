import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * The AddressBook class will store entries using an ArrayList
 */
public class AddressBook {
    ArrayList<AddressEntry> addressEntryList = new ArrayList<>();

    /**
     * This list method will iterate through an entry and print it using the toString method
     */
    public void list() {
        for (int i = 0; i < addressEntryList.size(); i++) {
            System.out.println(addressEntryList.get(i).toString());
        }
    }

    public void find(String startOf_lastName){

    }

    /**
     * Adds an address entry to the Arraylist
     *
     * @param addressEntry instance of AddressEntry used to add entries using the
     *                     constructor made in AddressEntry
     */
    public void add(AddressEntry addressEntry) {
        addressEntryList.add(addressEntry);
    }

    /**
     * removes an address entry from the ArrayList
     *
     * @param addressEntry instance of AddressEntry used to add entries using the
     *                     constructor made in AddressEntry
     */
    public void remove(AddressEntry addressEntry){
        addressEntryList.remove(addressEntry);
    }

    /**
     * Reads an address book entry from a file
     *
     * @param filename the name of the file should be entered so the program knows which file to read from
     */
    public static void readFromFile(String filename){
        AddressBook ab = new AddressBook();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = br.readLine()) != null){
                AddressEntry newEntry = new AddressEntry(line, br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.valueOf(br.readLine()).intValue(), br.readLine(), br.readLine());
                ab.add(newEntry);
                br.readLine();
            }
            br.close();

        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }
}
