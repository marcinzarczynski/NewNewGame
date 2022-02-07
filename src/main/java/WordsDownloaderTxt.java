import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordsDownloaderTxt implements Downloader {

//    private final static String filePath = "src\\wordsEasy.txt";


    @Override
    public Map<String, String> download(String path) throws IOException {
        return getHashMapFromFileTxt(path);
    }

    public Map<String,String> getHashMapFromFileTxt(String file) throws IOException{
        Map<String, String> words = new HashMap<>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;

        while ((line = br.readLine()) != null){
            String[] parts = line.split(":");

            String englishWord = parts[0].trim();
            String polishWord = parts[1].trim();

            if(!englishWord.equals("") && !polishWord.equals("")){
                words.put(englishWord, polishWord);
            }
        }
        return words;
    }

}
