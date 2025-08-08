import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private Map<String, String> contacts = new HashMap<>();

    public int add(String name, String phoneNumber) {
        if (!contacts.containsKey(name)) {
            contacts.put(name, phoneNumber);
        }
        return contacts.size();
    }
}
