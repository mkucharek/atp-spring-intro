package pl.com.tt.atp.provider.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.com.tt.atp.measurement.Measurement;
import pl.com.tt.atp.measurement.MeasurementProvider;

/**
 * @author mkucharek
 */
@Component
public class RandomMeasurementProvider implements MeasurementProvider {

    private final RandomSpeedGenerator speedGenerator;

    private final RandomLocationGenerator locationGenerator;

    @Autowired
    public RandomMeasurementProvider(RandomSpeedGenerator speedGenerator, RandomLocationGenerator locationGenerator) {
        this.speedGenerator = speedGenerator;
        this.locationGenerator = locationGenerator;
    }

    @Override
    public Measurement getLatestMeasurement() {
        return new Measurement(speedGenerator.getRandomSpeed(), locationGenerator.getRandomLocation());

    }

}
