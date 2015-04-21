package pl.com.tt.atp.provider.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author mkucharek
 */
@Component
public class RandomSpeedGenerator {

    private final Random random;

    @Value("${provider.random.speed.bound.upper}")
    private Integer speedUpperBound;

    @Autowired
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
