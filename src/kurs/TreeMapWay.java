package kurs;
/*
вариант решения п.1 через TreeMap, здесь слова выводятся в алфавитном порядке
*/
import java.util.Map;
import java.util.TreeMap;

public class TreeMapWay {
    private final String[] words;

    public TreeMapWay(String[] words) {
        this.words = words;
    }

    public void run() {
        Map<String, Integer> uniqueWords = new TreeMap<>();
        for (String word: words) {
            Integer count = uniqueWords.get(word);
            if (count == null) {
                uniqueWords.put(word, 1);
            } else {
                uniqueWords.put(word, count + 1);
            }
        }
        System.out.println("\n----- используем TreeMap<String, Integer> -----");
        System.out.println("Всего слов в массиве = " + words.length);
        System.out.println("Уникальных слов в массиве = " + uniqueWords.size());
        System.out.println("Сколько раз встречается каждое слово:");
        uniqueWords.forEach((key, value) -> System.out.printf("  %s = %d\n", key, value));
    }
}
