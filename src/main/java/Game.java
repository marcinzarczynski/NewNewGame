import java.util.Objects;

public class Game {
    WordsGame wordsGame;
    private Word currentWord;

    public Game(WordsGame wordsGame) {
        this.wordsGame = wordsGame;
        setNewCurrentWord();
    }

    public void setNewCurrentWord() {
        Word wordFromGame = wordsGame.getRandomWords().get(0);
        Word word = new Word(wordFromGame.getEng(), wordFromGame.getPl(), wordFromGame.getValue());
        currentWord = word;
    }

    public Word getCurrentWord() {
        return currentWord;
    }

    public boolean isGoodAnswer(String answer) {
        if (Objects.equals(answer, currentWord.getEng())) {
            return true;
        } else {
            return false;
        }
    }
}
