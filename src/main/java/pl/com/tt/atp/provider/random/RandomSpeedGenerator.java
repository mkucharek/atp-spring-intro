package pl.com.tt.atp.provider.random;

import java.util.Random;

/**
 * @author mkucharek
 */
public class RandomSpeedGenerator {

    private final Random random;

    private final Integer speedUpperBound;

    public RandomSpeedGenerator(Random random, Integer speedUpperBound) {
        this.random = random;
        this.speedUpperBound = speedUpperBound;
    }

    public Integer getRandomSpeed() {
        return random.nextInt(speedUpperBound);
    }
}
