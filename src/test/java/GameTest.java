
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class GameTest {

    Game game;

    @Test
    void shouldGetWordForGame() throws IOException  {
        RandomNumber randomNumber = new RandomNumber();
        Downloader downloaderTxt = new WordsDownloaderTxt();
        WordsGame wordsGame = new WordsGame(downloaderTxt, randomNumber, 24);;
        game = new Game(wordsGame);
        Word result = game.getCurrentWord();
        Word expectedWord = new Word("jabłko","apple",Point.EASY);

        assertEquals(expectedWord, result);

    }

}