package kurs;

import java.util.Objects;

public class CountedWord {
    private final String word;
    private int count;

    public CountedWord(String word) {
        this.word = word;
        this.count = 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountedWord that = (CountedWord) o;
        return word.equals(that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
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

    public int compareDescendingCounter(CountedWord that) {
        int thatCount = that.getCount();
        if (count == thatCount) {
            return word.compareTo(that.getWord());
        } else {
            return (count > thatCount) ? -1 : 1;
        }
    }
}
