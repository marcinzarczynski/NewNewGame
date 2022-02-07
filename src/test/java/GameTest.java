import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {

    private final static String filePath = "src\\wordsEasy.txt";

    @Mock
    private WordsGame wordsGame;

    Game game;

    @BeforeEach
    public void steUp() {
        when(wordsGame.getRandomWords()).thenReturn(List.of(
                new Word("jabłko", "apple", Point.EASY)));
        game = new Game(wordsGame);

    }

    @Test
    void shouldGetWordForGame()  {

        Word result = game.getCurrentWord();
        Word expectedWord = new Word("jabłko","apple",Point.EASY);

        assertEquals(expectedWord, result);

    }

}