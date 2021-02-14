package kurs;
/*
класс ТЕЛЕФОННАЯ КНИГА
*/
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final List<PhoneBookEntry> list = new ArrayList<>();

    public void add(String name, String phone) {
        list.add(new PhoneBookEntry(name, phone));
    }

    //поиск телефонов с использованием indexOf() и lastIndexOf()
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

    //поиск телефонов перебором
    public void getBruteForce(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        for (PhoneBookEntry phoneBookEntry: list) {
            if (!name.equals(phoneBookEntry.getName())) {
                continue;
            }
            if (stringBuilder.length() != 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(phoneBookEntry.getPhone());
        }
        if (stringBuilder.length() == 0) {
            System.out.println(name + ": телефон не найден");
        } else {
            System.out.println(name + ": " + stringBuilder.toString());
        }
    }
}
