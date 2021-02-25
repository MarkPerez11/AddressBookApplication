import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    @Test
    void list() {
    }

    @Test
    void add() {
        AddressEntry ab = new AddressEntry("fname", "lname", "st", "city", "state", 1234, "hdak@hg", "209-809-0008");
        AddressEntry ab1 = new AddressEntry("Fname", "Lname", "street", "city", "state", 5678, "email@gmail.com", "123-456-7890");
    }

    @Test
    void remove() {
    }

    @Test
    void readFromFile() {
    }
}