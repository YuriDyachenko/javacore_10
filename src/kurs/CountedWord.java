package kurs;
/*
класс СЛОВО СО СЧЕТЧИКОМ
*/
public class CountedWord {
    private final String word;
    private int count;

    public CountedWord(String word) {
        this.word = word;
        this.count = 1;
    }

    //переопределяем, чтобы indexOf искал только по слову без учета счетчика
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountedWord that = (CountedWord) o;
        return word.equals(that.word);
    }

    @Override
    public String toString() {
        return "  " + word + " = " + count;
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    //для сортировки по убыванию счетчика
    public int compareDescendingCounter(CountedWord that) {
        int thatCount = that.getCount();
        if (count == thatCount) {
            return word.compareTo(that.getWord());
        } else {
            return (count > thatCount) ? -1 : 1;
        }
    }
}
