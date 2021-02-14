package kurs;
/*
вариант решения п.1 через HashMap, но слова выводятся не в алфавитном порядке, а как попало
*/
import java.util.HashMap;
import java.util.Map;

public class HashMapWay {
    private final String[] words;

    public HashMapWay(String[] words) {
        this.words = words;
    }

    public void run() {
        Map<String, Integer> uniqueWords = new HashMap<>();
        for (String word: words) {
            Integer count = uniqueWords.get(word);
            if (count == null) {
                uniqueWords.put(word, 1);
            } else {
                uniqueWords.put(word, count + 1);
            }
        }
        System.out.println("\n----- используем HashMap<String, Integer> -----");
        System.out.println("Всего слов в массиве = " + words.length);
        System.out.println("Уникальных слов в массиве = " + uniqueWords.size());
        System.out.println("Сколько раз встречается каждое слово:");
        uniqueWords.forEach((key, value) -> System.out.printf("  %s = %d\n", key, value));
    }
}
