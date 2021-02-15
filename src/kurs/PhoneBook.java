package kurs;
/*
класс ТЕЛЕФОННАЯ КНИГА
используется обычый ArrayList, т.е. все неотсортированно и "очень медленно"
*/
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private final List<PhoneBookEntry> list = new ArrayList<>();

    public void add(String name, String phone) {
        PhoneBookEntry entry = new PhoneBookEntry(name, phone);
        if (!list.contains(entry)) {
            list.add(entry);
        }
    }

    public void get(String name) {
        StringBuilder builder = new StringBuilder();
        for (PhoneBookEntry entry: list) {
            if (name.equals(entry.getName())) {
                builder.append(builder.length() == 0 ? "" : ", ").append(entry.getPhone());
            }
        }
        System.out.println(name + ": " + (builder.length() == 0 ? "телефон не найден" : builder.toString()));
    }
}
