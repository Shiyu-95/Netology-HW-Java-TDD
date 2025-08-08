import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, String> contacts = new HashMap<>();
    private final Map<String, String> numbersToNames = new HashMap<>();

    public String findByNumber(String number) {
        return numbersToNames.get(number);
    }

    public String findByName(String name) {
        return contacts.get(name);
    }

    public void printAllNames() {

    }

    public int add(String name, String phoneNumber) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, phoneNumber);
            numbersToNames.put(phoneNumber, name); // <-- добавить эту строку
        }
        return contacts.size();
    }
}
