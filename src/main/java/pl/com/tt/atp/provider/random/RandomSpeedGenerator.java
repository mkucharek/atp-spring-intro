package pl.com.tt.atp.provider.random;

import java.util.Random;

/**
 * @author mkucharek
 */
public class RandomSpeedGenerator {

    private final Random random;

    private Integer speedUpperBound;

    public RandomSpeedGenerator(Random random) {
        this.random = random;
    }

    public void setSpeedUpperBound(Integer speedUpperBound) {
        this.speedUpperBound = speedUpperBound;
    }

    public Integer getRandomSpeed() {
        return random.nextInt(speedUpperBound);
    }
}
