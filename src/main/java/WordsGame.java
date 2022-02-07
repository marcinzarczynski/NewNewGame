import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordsGame {
    private final Downloader downloader;
    private final static String filePath = "src\\wordsEasy.txt";
    private final List<Word> words;
    private final List<Word> randomWords;
    int proportionOfGame = 24;
    private final RandomNumber randomNumber;

    public WordsGame(Downloader downloader, RandomNumber randomNumber) throws IOException {
        this.downloader = downloader;
        this.words = createWords(Point.EASY, downloader.download(filePath));
        this.randomWords = getProportionsOfRandomWords();
        this.randomNumber = randomNumber;
    }

    public void setProportionOfGame(int proportionOfGame) {
        this.proportionOfGame = proportionOfGame;
    }

    public List<Word> getWordsFromWordsGame() {
        return this.words;
    }

    public List<Word> getRandomWords() {
        return this.randomWords;
    }

    private List<Word> createWords(Point point, Map<String, String> wordsMap) {
        List<Word> words = new ArrayList<>();

        for (Map.Entry<String, String> entry : wordsMap.entrySet()) {
            words.add(new Word(entry.getKey(), entry.getValue(), point));
        }
        return words;
    }

    private List<Word> getProportionsOfRandomWords() {
        List<Word> words = new LinkedList<>();
        for (int i = 0; i < proportionOfGame; i++) {
            int number = proportionOfGame -i;
            Word tmp = this.words.get(randomNumber.getRandomNumber(proportionOfGame - i));
            Word word = new Word(tmp.getPl(), tmp.getEng(), tmp.getValue());
            words.add(word);
            this.words.remove(tmp);
        }
        return words;
    }
}
