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

    public static void main(String[] args) {

        String[] words = {"ангельская", "божественная", "безупречная", "завораживающая", "бесподобная",
                "жизнерадостная", "бескорыстная", "божественная", "весёлая", "великолепная", "безупречная",
                "завораживающая", "ангельская", "жизнерадостная", "восхитительная", "завораживающая",
                "волнительная", "грациозная", "добрая", "безупречная", "душевная", "ангельская",
                "божественная", "завораживающая", "дивная", "единственная", "желанная", "жизнерадостная",
                "заботливая", "загадочная", "божественная", "жизнерадостная", "завораживающая",
                "застенчивая", "зажигательная", "изысканная"};

        //используем HashMap, но список слов не отсортирован, трудно понять, есть там повторения или нет
        HashMapWay hashMapWay = new HashMapWay(words);
        hashMapWay.run();

        //используем, теперь список слов в алфавитном порядке
        TreeMapWay treeMapWay = new TreeMapWay(words);
        treeMapWay.run();

        //вариант списка объектов своего класса, позволит дополнительно сортировать как угодно
        //например, по убыванию встречаемости слов
        SeparateClassWay separateClassWay = new SeparateClassWay(words);
        separateClassWay.run();

        //телефонная книга
        PhoneBook phoneBook = new PhoneBook();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            phoneBook.add(words[random.nextInt(words.length)],
                    "" + (4950000000L + new Random().nextInt(10000000)));
        }
        for (int i = 0; i < 10; i++) {
            phoneBook.get(words[random.nextInt(words.length)]);
        }

    }
}
