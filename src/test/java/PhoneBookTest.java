import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneBookTest {

    PhoneBook phoneBook = new PhoneBook();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        phoneBook = new PhoneBook();
        System.setOut(new PrintStream(outContent));
    }


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
    void testPrintAllNamesEmpty() {
        phoneBook.printAllNames();
        assertEquals("", outContent.toString().trim(), "При пустой книге вывод должен быть пустым");
    }

    @Test
    void testPrintAllNamesSorted() {
        phoneBook.add("Charlie", "+333");
        phoneBook.add("Alice", "+111");
        phoneBook.add("Bob", "+222");

        phoneBook.printAllNames();

        String output = outContent.toString().trim();
        String[] lines = output.split("\\r?\\n");

        assertArrayEquals(new String[]{"Alice", "Bob", "Charlie"}, lines, "Имена должны быть выведены в алфавитном порядке");
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

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }
}
