import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * The AddressBook class will store entries using an ArrayList
 */
public class AddressBook extends AddressEntry{
    private static ArrayList<AddressEntry> addressEntryList = new ArrayList<>();

    /**
     * This list method will iterate through an entry and print it using the toString method
     */
    public void list() {
        for (int i = 0; i < addressEntryList.size(); i++) {
            System.out.println(addressEntryList.get(i).toString());
        }
    }

    /**
     * method will first compare the last name of an address entry, then compare by
     * first name if there happens to be more than one address entry with the same last name
     *
     * Method will be also be used in the case where user wants to remove a contact that has the same name
     * as another contact in the address book
     */
    public static void sort(){
        Comparator<AddressEntry> lastNameComparator = Comparator.comparing(AddressEntry::getLastName);
        Comparator<AddressEntry> firstNameComparator = Comparator.comparing(AddressEntry::getFirstName);
        Collections.sort(addressEntryList, lastNameComparator.thenComparing(firstNameComparator));
    }

    /**
     * Method will prompt the user to enter the last name of the contact they are looking for and
     * will return all available contacts with that name
     *
     * @param startOf_lastName last name that user will input to search for contact in arraylist
     */
    public static List<AddressEntry> find(String startOf_lastName){
        sort();
        //used for matching entries
        List<AddressEntry> matchingEntry = new ArrayList<>();
        //used for index of entries
        List<Integer> entryIndex = new ArrayList<>();
        //used for last names to compare
        List<String> LastName = new ArrayList<>();

        for (AddressEntry entry: addressEntryList){
            LastName.add(entry.getLastName());
        }

        // Comparator will be used so that even if the full last name isn't given, it will still return it
        Comparator<String> containsComparator = (o1, o2) -> {
            if (o1.contains(o2)){
                return 0;
            }
            else{
                return o1.compareTo(o2);
            }
        };

        entryIndex.add(Collections.binarySearch(LastName, startOf_lastName, containsComparator));
        int Index = entryIndex.get(0);
        if(Index >= 0){
            int i = Index + 1;
            while(i < LastName.size() && LastName.get(i).contains(startOf_lastName)){
                entryIndex.add(i);
                i++;
            }
        }

        for(Integer i: entryIndex){
            if(i >= 0){
                matchingEntry.add(addressEntryList.get(i));
            }
        }
        return matchingEntry;
    }

    /**
     * Adds an address entry to the Arraylist
     *
     * @param addressEntry instance of AddressEntry to be added to
     *                     the address book
     */
    public void add(AddressEntry addressEntry) {
        addressEntryList.add(addressEntry);
    }

    /**
     * removes an address entry from the ArrayList
     *
     * @param addressEntry instance of AddressEntry that will be removed
     *                     from the address book
     */
    public static void remove(AddressEntry addressEntry){
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
            }
            br.close();

        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }
}
