import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Objects;

public class Game {
    WordsGame wordsGame;
    private Word currentWord;

    public Game(WordsGame wordsGame) {
        this.wordsGame = wordsGame;
        currentWord = getWord(0);
    }

    private Word getWord(int index){
        Word wordFromGame = wordsGame.getRandomWords().get(index);
        Word word = new Word(wordFromGame.getEng(),wordFromGame.getPl(),wordFromGame.getValue());
        wordsGame.getRandomWords().remove(wordFromGame);
        return word;
    }

//    public void setNewCurrentWord(){
//        currentWord = getWord(0);
//    }

    public Word getCurrentWord(){ return currentWord;}

    public boolean isGoodAnswer(String answer) {
        if (Objects.equals(answer, currentWord.getEng())) {
            return true;
        } else {
            return false;
        }
    }



}
