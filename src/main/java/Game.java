import java.util.Objects;

public class Game {
    WordsGame wordsGame;
    private Word currentWord;


    public Game(WordsGame wordsGame) {
        this.wordsGame = wordsGame;
        setNewCurrentWordAfterGoodAnswer();

    }

    public void setNewCurrentWordAfterGoodAnswer() {
        RandomNumber randomNumber = new RandomNumber();
        int randomNumberForGame = randomNumber.getRandomNumber(wordsGame.randomWords.size());
        Word wordFromGame = wordsGame.getRandomWords().get(randomNumberForGame);
        currentWord = new Word(wordFromGame.getEng(), wordFromGame.getPl(), wordFromGame.getValue());
        wordsGame.randomWords.remove(randomNumberForGame);
    }
    public void setNewCurrentWordAfterBadAnswer() {
        RandomNumber randomNumber = new RandomNumber();
        Word wordFromGame = wordsGame.getRandomWords().get(randomNumber.getRandomNumber(wordsGame.randomWords.size()));
        currentWord = new Word(wordFromGame.getEng(), wordFromGame.getPl(), wordFromGame.getValue());
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
