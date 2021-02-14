package kurs;
/*
вариант решения п.1 через отдельный класс, где сортируем, как хотим
*/
import java.util.*;

public class SeparateClassWay {
    private final String[] words;

    public SeparateClassWay(String[] words) {
        this.words = words;
    }

    public void run() {
        List<CountedWord> list = new ArrayList<>();

        for (String word: words) {
            CountedWord countedWord = new CountedWord(word);
            int position = list.indexOf(countedWord);
            if (position == -1) {
                list.add(countedWord);
            } else {
                list.get(position).increment();
            }
        }

        list.sort(new Comparator<CountedWord>() {
            @Override
            public int compare(CountedWord o1, CountedWord o2) {
                return o1.compareDescendingCounter(o2);
            }
        });

        System.out.println("\n----- используем ArrayList -----");
        System.out.println("Всего слов в массиве = " + words.length);
        System.out.println("Уникальных слов в массиве = " + list.size());
        System.out.println("Сколько раз встречается каждое слово (по убыванию):");
        for (CountedWord countedWord: list) {
            System.out.println(countedWord);
        }
    }
}
