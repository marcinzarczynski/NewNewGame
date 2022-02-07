import java.io.IOException;
import java.util.Map;

public interface Downloader {
    Map<String, String> download(String path) throws IOException;
}