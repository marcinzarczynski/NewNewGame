import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WordsDownloaderTxtTest {



    @Test
    void shouldLoadWordsFromFileTxtToHashmap() throws IOException {

        var sut = new WordsDownloaderTxt();
        var expectedWords = Map.of("apple","jabłko",
                "wood","drewno",
                "stone","kamień",
                "castle","zamek");

        var  result = sut.
                download("src\\test\\resources\\wordsEasy.txt");


        Assertions.assertEquals(4, result.size());
        Assertions.assertEquals(expectedWords, result);

    }

    @Test
    void shouldNotFindFile() throws IOException{
        var sut = new WordsDownloaderTxt();
        FileNotFoundException thrown = assertThrows(FileNotFoundException.class,
                () -> sut.download("src\\comy\\test\\wordsEasy.txt"));
    }


}