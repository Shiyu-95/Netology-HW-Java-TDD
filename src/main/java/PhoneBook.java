import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    private TreeMap<String, String> contacts = new TreeMap<>();
    private final Map<String, String> numbersToNames = new HashMap<>();

    public String findByNumber(String number) {
        return numbersToNames.get(number);
    }

    public String findByName(String name) {
        return contacts.get(name);
    }

    public void printAllNames() {
        for (String name : contacts.keySet()) {
            System.out.println(name);
        }
    }

    public int add(String name, String phoneNumber) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, phoneNumber);
            numbersToNames.put(phoneNumber, name); // <-- добавить эту строку
        }
        return contacts.size();
    }
}
