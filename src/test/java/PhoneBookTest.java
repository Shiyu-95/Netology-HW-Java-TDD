import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();


    @Test
    void testFindByNumberReturnsName() {
        phoneBook.add("Alice", "+111");
        phoneBook.add("Bob", "+222");

        assertEquals("Alice", phoneBook.findByNumber("+111"));
        assertEquals("Bob", phoneBook.findByNumber("+222"));
    }

    @Test
    void testFindByNumberReturnsNullIfNotFound() {
        phoneBook.add("Charlie", "+333");
        assertNull(phoneBook.findByNumber("+999"), "Должна возвращаться null для отсутствующего номера");
    }

    @Test
    void testFindByNameReturnsNumber() {
        phoneBook.add("Alice", "+111");
        phoneBook.add("Bob", "+222");

        assertEquals("+111", phoneBook.findByName("Alice"));
        assertEquals("+222", phoneBook.findByName("Bob"));
    }

    @Test
    void testFindByNameReturnsNullIfNotFound() {
        phoneBook.add("Charlie", "+333");
        assertNull(phoneBook.findByName("NonExist"), "Должна возвращаться null, если имя отсутствует");
    }

    @Test
    void testAddNewContactReturnsOne() {
        int count = phoneBook.add("Alice", "+123456789");
        assertEquals(1, count, "После добавления одного контакта размер должен быть 1");
    }

    @Test
    void testAddDuplicateNameDoesNotIncreaseCount() {
        phoneBook.add("Bob", "+11111111");
        int count = phoneBook.add("Bob", "+22222222");
        assertEquals(1, count, "При добавлении дубля, размер не должен увеличиваться");
    }
    }
