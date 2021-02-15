package kurs;
/*
класс ЗАПИСЬ ТЕЛЕФОННОЙ КНИГИ
*/
public class PhoneBookEntry {
    private final String name;
    private final String phone;

    public PhoneBookEntry(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    //переопределяем, чтобы indexOf/lastIndexOf искали только по имени без учета телефона
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBookEntry that = (PhoneBookEntry) o;
        return name.equals(that.name);
    }
}
