public class GameMenager {

    final Game game;
    private int points = 0;

    public GameMenager(Game game) {
        this.game = game;
    }
    public int getPoints(){ return points;}

    public Word getCurrentWord() {
        return game.getCurrentWord();
    }

    public boolean checkAnswer(String answer) {
        if (game.isGoodAnswer(answer)) {
            points += game.getCurrentWord().getValue().getValue();
            return true;
        }
        points--;
        return false;
    }

}

