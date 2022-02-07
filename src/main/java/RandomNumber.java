import java.util.Random;

class RandomNumber {
    private final Random random = new Random();

    int getRandomNumber(int range) {
        return random.nextInt(range);
    }

}