/**
 * This class will specify what is an address entry
 */
public class AddressEntry {
    String firstName;
    String lastName;
    String street;
    String city;
    String state;
    int zip;
    String phone;
    String email;


    /**
     * default constructor used to create new instances of AddressEntry
     */
    public AddressEntry(){}

    /**
     * class constructor containing parameters needed to add an address to AddressBook
     *
     * @param firstName The first name of person
     * @param lastName The last name of person
     * @param street The street name
     * @param state The name of state
     * @param zip Zip code
     * @param phone Phone number associated with person
     * @param email Email associated with person
     */
    public AddressEntry(String firstName, String lastName, String street, String city, String state, int zip, String email, String phone){
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
    }

    /**
     * Returns the person and corresponding info in a specified manner
     *
     * @return first + last name + corresponding info
     */
    public String toString(){
        return "(" + firstName + ", " + lastName + ", " + street + ", " + city + ", " + state + ", " + zip + ", " + phone + ", " + email + ")";
    }

    /**
     * sets the name given as first name
     *
     * @param firstName first name of contact
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * retrieves the last name
     *
     * @return returns the last name
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * retrieves the first name
     *
     * @return returns the first name
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * sets the name given as last name
     *
     * @param lastName the last name of a contact
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    /**
     * sets the city given as city
     *
     * @param city the city where a contact lives
     */
    public void setCity(String city){
        this.city = city;
    }

    /**
     * retrieves the city
     *
     * @return returns the city
     */
    public String getCity(){
        return city;
    }

    /**
     * sets the state given as state
     *
     * @param state the state where the contact lives
     */
    public void setState(String state){
        this.state = state;
    }

    /**
     * retrieves the state
     *
     * @return returns the state
     */
    public String getState(){
        return state;
    }

    /**
     * sets the street given as street
     *
     * @param street the street a contact lives on
     */
    public void setStreet(String street){
        this.street = street;
    }

    /**
     * retrieves the street
     *
     * @return returns the street
     */
    public String getStreet(){
        return street;
    }

    /**
     * sets the zip given as zip
     *
     * @param zip the zip code of a contact
     */
    public void setZip(int zip){
        this.zip = zip;
    }

    /**
     * retrieves the zip
     *
     * @return return the zip code
     */
    public int getZip(){
        return zip;
    }

    /**
     * sets the phone number given as phone
     *
     * @param phone the phone number of a contact
     */
    public void setPhone(String phone){
        this.phone = phone;
    }

    /**
     * retrieves the phone number
     *
     * @return returns the phone number
     */
    public String getPhone(){
        return phone;
    }

    /**
     * sets the email given as email
     *
     * @param email the email of a contact
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * retrieves the email
     *
     * @return returns the email of a contact
     */
    public String getEmail(){
        return email;
    }
}
