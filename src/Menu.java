import java.util.Scanner;
import java.io.File;
import java.util.List;

class Menu extends AddressBook{
    Scanner scan = new Scanner(System.in);
    AddressBook addressBook = new AddressBook();

    /**
     * Main Menu that prompts the user to choose from 6 options
     * Options: Load, Add, Remove, Find, Listing, Quit
     * method will then call other methods to execute the options commands
     */
    public void menuSelection(){
        int choice = 0;
        String input;
        char quit = 'n';
        while(quit != 'y') {
            System.out.println("1) Loading from file");
            System.out.println("2) Addition");
            System.out.println("3) Removal");
            System.out.println("4) Find");
            System.out.println("5) Listing");
            System.out.println("6) Quit\n");
            System.out.println("Enter number choice(1-6): ");
            choice = scan.nextInt();
            scan.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Enter file name: ");
                    String filename = scan.nextLine();
                    addressBook.readFromFile(filename);
                    break;
                case 2:
                    addMenu();
                    break;
                case 3:
                    removeMenu();
                    break;
                case 4:
                    findMenu();
                    break;
                case 5:
                    addressBook.list();
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("\nGoodbye.");
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid number.");
            }
        }
    }

    /**
     * Calls the other methods in this class to create an add menu
     * Uses that menu to get user input to the add a contact to address book
     *
     */
    public void addMenu(){
        prompt_FirstName();
        String first_name = scan.nextLine();

        prompt_LastName();
        String last_name = scan.nextLine();

        prompt_Street();
        String street = scan.nextLine();

        prompt_City();
        String city = scan.nextLine();

        prompt_State();
        String state = scan.nextLine();

        prompt_Zip();
        int zip = scan.nextInt();
        scan.nextLine();

        prompt_Email();
        String email = scan.nextLine();

        prompt_Phone();
        String phone = scan.nextLine();

        AddressEntry newEntry = new AddressEntry(first_name, last_name, street, city, state, zip, phone, email);
        addressBook.add(newEntry);
        addressBook.sort();
        System.out.println("Thank you, the following contact has been added to your address book:");
        System.out.println(newEntry + "\n");
    }

    /**
     * A menu that will return the contacts with last name entered by user then ask
     * which contact they wish to remove
     */
    public void removeMenu(){
        String lastName;
        int remove = 0;
        System.out.println("Enter in the last name of the contact you want to remove:");
        lastName = scan.nextLine();

        List<AddressEntry> contactsFound = AddressBook.find(lastName);
        if(contactsFound.size() >= 1){
            int count = 1;
            System.out.println("The following contacts were found. Please enter the number of the entry you wish to remove:");
            for(AddressEntry entry: contactsFound){
                System.out.println(count + ": " + entry);
                count++;
            }
            try{
                remove = scan.nextInt();
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a valid number.");
            }
            AddressBook.remove(contactsFound.get(remove - 1));
            System.out.println("The contact has been removed.\n");
        }
    }

    public void findMenu(){
        System.out.println("Enter in all or the beginning of the last name of the contact you wish to find:");
        String lName = scan.nextLine();
        System.out.println("The following entries were found:");

        List<AddressEntry> contactsFound = AddressBook.find(lName);
        if(contactsFound.size() >= 1){
            for(AddressEntry entry : contactsFound){
                System.out.println(entry);
            }
        }
        else{
            System.out.println("No entries were found.");
        }
    }


    /**
     * prompt_FirstName  generates a standard output prompt for the First Name to be entered
     */
    public static void prompt_FirstName() {
        System.out.println("First Name: ");
    }

    /**
     *  prompt_LastName generates a standard output prompt for the Last Name to be entered
     */
    public static void prompt_LastName() {
        System.out.println("Last Name: ");
    }

    /**
     * prompt_Street generates a standard output prompt for the Street to be entered
     */
    public static void prompt_Street() {
        System.out.println("Street: ");
    }

    /**
     * prompt_City generates a standard output prompt for the City to be entered
     */
    public static void prompt_City() {
        System.out.println("City: ");
    }

    /**
     * prompt_State generates a standard output prompt for the State to be entered
      */
    public static void prompt_State(){
        System.out.println("State: ");
    }

    /**
     *prompt_Zip generates a standard output prompt for the Zip to be entered
     */
    public static void prompt_Zip() {
        System.out.println("Zip: ");
    }

    /**
     * prompt_Telephone generates a standard output prompt for the Telephone number to be entered
     */
    public static void prompt_Phone() {
        System.out.println("Phone number: ");
    }

    /**
     * prompt_Email generates a standard output prompt for the Email to be entered
     */
    public static void prompt_Email(){
        System.out.println("Email: ");
    }
}
