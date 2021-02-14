package kurs;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final List<PhoneBookEntry> list = new ArrayList<>();

    public void add(String name, String phone) {
        list.add(new PhoneBookEntry(name, phone));
    }

    public void get(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (PhoneBookEntry phoneBookEntry: list) {
            if (!name.equals(phoneBookEntry.getName())) {
                continue;
            }
            if (count != 0) {
                stringBuilder.append(", ");
            }
            count++;
            stringBuilder.append(phoneBookEntry.getPhone());
        }
        if (count == 0) {
            System.out.println(name + ": телефон не найден");
        } else {
            System.out.println(name + ": " + stringBuilder.toString());
        }
    }
}
