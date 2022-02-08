import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            GameMenager gameMenager = new GameMenager();
            gameMenager.startNewGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
