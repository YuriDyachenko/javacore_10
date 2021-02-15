package kurs;
/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
Посчитать, сколько раз встречается каждое слово.
2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной
фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой
фамилии должны выводиться все телефоны.
*/
import java.util.Random;

public class Main {

    private static final String[] WORDS = {"ангельская", "божественная", "безупречная",
            "жизнерадостная", "бескорыстная", "божественная", "весёлая", "великолепная", "безупречная",
            "завораживающая", "ангельская", "жизнерадостная", "восхитительная", "завораживающая",
            "волнительная", "грациозная", "добрая", "безупречная", "душевная", "ангельская",
            "божественная", "завораживающая", "дивная", "единственная", "желанная", "жизнерадостная",
            "заботливая", "загадочная", "божественная", "жизнерадостная", "завораживающая",
            "застенчивая", "зажигательная", "изысканная", "бесподобная", "завораживающая"};
    private static final Random random = new Random();

    public static void main(String[] args) {

        //используем HashMap, но список слов не отсортирован, трудно понять, есть там повторения или нет
        HashMapWay hashMapWay = new HashMapWay(WORDS);
        hashMapWay.run();

        //используем, теперь список слов в алфавитном порядке
        TreeMapWay treeMapWay = new TreeMapWay(WORDS);
        treeMapWay.run();

        //вариант списка объектов своего класса, позволит дополнительно сортировать как угодно
        //например, по убыванию встречаемости слов
        SeparateClassWay separateClassWay = new SeparateClassWay(WORDS);
        separateClassWay.run();

        //для двух вариантов решения сразу создаем объекты, чтобы добавить в них
        //одинаковые данные и сравнивать потом работу get
        PhoneBook phoneBook = new PhoneBook();
        TreeMapPhoneBook treeMapPhoneBook = new TreeMapPhoneBook();
        //заполняем обе книги одинаковыми значениями
        for (int i = 0; i < 20; i++) {
            String word = randomWord();
            String phone = randomPhone();
            phoneBook.add(word, phone);
            treeMapPhoneBook.add(word, phone);
        }
        //создаем и заполняе массив для тестирования get
        String[] testWords = new String[10];
        for (int i = 0; i < testWords.length; i++) {
            testWords[i] = randomWord();
        }
        //поиск в первой книге
        System.out.println("\n----- телефонная книга, используем ArrayList -----");
        for (String testWord : testWords) {
            phoneBook.get(testWord);
        }
        //поиск во второй книге
        System.out.println("\n----- телефонная книга, используем TreeMap<String, TreeSet<String>> -----");
        for (String testWord : testWords) {
            treeMapPhoneBook.get(testWord);
        }
    }

    public static String randomWord() {
        return WORDS[random.nextInt(WORDS.length)];
    }

    public static String randomPhone() {
        return "" + (4950000000L + new Random().nextInt(10000000));
    }
}
