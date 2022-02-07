import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WordsGameTest {

    private final static String filePath = "src\\wordsEasy.txt";
    @Mock
    private Downloader downloaderTxt;

    @Mock
    private RandomNumber randomNumber;

    private WordsGame wordsGame;

    @BeforeEach
    public void steUp() throws IOException {
        when(downloaderTxt.download(filePath)).thenReturn(Map.of(
                "apple", "jabłko",
                "wood", "drewno",
                "stone", "kamień",
                "castle", "zamek"));

        when(randomNumber.getRandomNumber(4)).thenReturn(1, 0, 3, 2);
        wordsGame = new WordsGame(downloaderTxt, randomNumber, 4);
    }


    @Test
    void shouldCreateListWithKeyValueAndPoint() {

        var expectedWords = Arrays.asList(
                new Word("apple", "jabłko", Point.EASY),
                new Word("wood", "drewno", Point.EASY),
                new Word("stone", "kamień", Point.EASY),
                new Word("castle", "zamek", Point.EASY));

        assertTrue(expectedWords.containsAll(wordsGame.getWordsFromWordsGame()));
    }

    @Test
    void shouldCreateListWithRandomWords() {
        var expectedWords = Arrays.asList(
                new Word("wood", "drewno", Point.EASY),
                new Word("apple", "jabłko", Point.EASY),
                new Word("castle", "zamek", Point.EASY),
                new Word("stone", "kamień", Point.EASY));

        assertTrue(expectedWords.containsAll(wordsGame.getRandomWords()));

    }
}