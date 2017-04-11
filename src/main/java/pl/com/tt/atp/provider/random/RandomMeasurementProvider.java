package pl.com.tt.atp.provider.random;

import pl.com.tt.atp.measurement.Measurement;
import pl.com.tt.atp.measurement.MeasurementProvider;

/**
 * @author mkucharek
 */
public class RandomMeasurementProvider implements MeasurementProvider {

    private final RandomSpeedGenerator speedGenerator;
    private final RandomLocationGenerator locationGenerator;

    public RandomMeasurementProvider(RandomSpeedGenerator speedGenerator, RandomLocationGenerator locationGenerator) {
        this.speedGenerator = speedGenerator;
        this.locationGenerator = locationGenerator;
    }

    @Override
    public Measurement getLatestMeasurement() {
        return new Measurement(speedGenerator.getRandomSpeed(), locationGenerator.getRandomLocation());

    }

}
