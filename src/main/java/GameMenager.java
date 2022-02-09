import java.io.IOException;
import java.util.Scanner;

public class GameMenager {

    final Game game;
    private int points = 0;
    String answer;
    int proportionOfGame = 24;
    WordsGame wordsGame;

    public GameMenager() throws IOException {
        Downloader downloader = new WordsDownloaderTxt();
        RandomNumber randomNumber = new RandomNumber();
        this.wordsGame = new WordsGame(downloader, randomNumber, proportionOfGame);
        this.game = new Game(wordsGame);
    }

    public int getPoints() {
        return points;
    }

    private Word getCurrentWord() {
        return game.getCurrentWord();
    }

    public boolean checkAnswer(String answer) {
        if (game.isGoodAnswer(answer)) {
            points += game.getCurrentWord().getValue().getValue();
            System.out.println("Poprawna odpowiedź, pozostało " +
                    wordsGame.randomWords.size() + " słówek");
            return true;
        }
        points--;
        System.out.println("Błędna odpowiedź, przechodzisz do następnego słówka");
        return false;
    }

    public void startNewGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witamy w grze, gdzie odgadujesz angielski odpowiednik polskich słówek!");

        while (!wordsGame.randomWords.isEmpty()) {
            System.out.println("Podaj angielskie słówko");
            System.out.println(getCurrentWord().getPl());
            this.answer = scanner.nextLine();
            boolean checkedAnswer = checkAnswer(answer);
            if (checkedAnswer) {
                game.setNewCurrentWordAfterGoodAnswer();
                System.out.println("Twoja liczba punktów: " + getPoints());
            } else {
                game.setNewCurrentWordAfterBadAnswer();
                System.out.println("Twoja liczba punktów: " + getPoints());
            }
        }
        if (wordsGame.randomWords.isEmpty()) {
            System.out.println("Twoja liczba punktów: " + getPoints());
        }
    }
}

