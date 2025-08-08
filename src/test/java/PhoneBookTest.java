import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();

    @Test
    void testAddNewContactReturnsOne() {
        HashMap<String, String> count = phoneBook.add("Alice", "+123456789");
        assertEquals(1, count, "После добавления одного контакта размер должен быть 1");
    }

    @Test
    void testAddDuplicateNameDoesNotIncreaseCount() {
        phoneBook.add("Bob", "+11111111");
        HashMap<String, String> count = phoneBook.add("Bob", "+22222222");
        assertEquals(1, count, "При добавлении дубля, размер не должен увеличиваться");
    }
    }
