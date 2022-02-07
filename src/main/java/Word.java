import java.util.Objects;

public class Word {
    String pl;
    String eng;
    Point value;

    public Word(String pl, String eng, Point value) {
        this.pl = pl;
        this.eng = eng;
        this.value = value;
    }

    public String getPl() { return pl; }
    public String getEng() { return eng; }
    public Point getValue() { return value; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(pl, word.pl) && Objects.equals(eng, word.eng) && value == word.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pl, eng, value);
    }

    @Override
    public String toString() {
        return "Word{" +
                "pl='" + pl + '\'' +
                ", eng='" + eng + '\'' +
                ", value=" + value.getValue() +
                '}';
    }
}
