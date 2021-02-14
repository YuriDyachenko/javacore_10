package kurs;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final List<PhoneBookEntry> list = new ArrayList<>();

    public void add(String name, String phone) {
        list.add(new PhoneBookEntry(name, phone));
    }

    public void get(String name) {
        PhoneBookEntry temp = new PhoneBookEntry(name, "");
        int startIndex = list.indexOf(temp);
        if (startIndex == -1) {
            System.out.println(name + ": телефон не найден");
            return;
        }
        int lastIndex = list.lastIndexOf(temp);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = startIndex; i <= lastIndex; i++) {
            temp = list.get(i);
            if (!name.equals(temp.getName())) {
                continue;
            }
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(temp.getPhone());
        }
        System.out.println(name + ": " + stringBuilder.toString());
    }

    public void getBruteForce(String name) {
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
