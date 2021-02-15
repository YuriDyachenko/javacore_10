package kurs;
/*
класс ТЕЛЕФОННАЯ КНИГА***
все отсортировано, как фамилии, так и телефоны "внутри фамилии"
должен получиться самый быстрый поиск, та как везде используется hash
не требуются никакие дополнительные классы типа запись телефонной книги
*/
import java.util.*;

public class TreeMapPhoneBook {
    private final Map<String, Set<String>> map = new TreeMap<>();

    public void add(String name, String phone) {
        Set<String> phones = map.get(name);
        if (phones == null)
            phones = new TreeSet<>();
        phones.add(phone);
        map.put(name, phones);
    }

    public void get(String name) {
        Set<String> phones = map.get(name);
        if (phones == null || phones.size() == 0)
            System.out.println(name + ": телефон не найден");
        else
            System.out.println(name + ": " + phonesToString(phones));
    }

    public String phonesToString(Set<String> phones) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String phone: phones) {
            stringBuilder.append(stringBuilder.length() == 0 ? "" : ", ").append(phone);
        }
        return stringBuilder.toString();
    }
}
