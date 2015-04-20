package pl.com.tt.atp.provider.random;

import pl.com.tt.atp.measurement.Location;

import java.util.Random;

/**
 * @author mkucharek
 */
public class RandomLocationGenerator {

    private final Random random;

    private final Double latitudeLowerBound;
    private final Double latitudeUpperBound;
    private final Double longitudeUpperBound;
    private final Double longitudeLowerBound;

    public RandomLocationGenerator(
            Random random,
            Double latitudeLowerBound,
            Double latitudeUpperBound,
            Double longitudeLowerBound,
            Double longitudeUpperBound) {

        this.random = random;
        this.latitudeLowerBound = latitudeLowerBound;
        this.latitudeUpperBound = latitudeUpperBound;
        this.longitudeLowerBound = longitudeLowerBound;
        this.longitudeUpperBound = longitudeUpperBound;
    }

    public Location getRandomLocation() {
        Double latitude = latitudeLowerBound + random.nextDouble() * (latitudeUpperBound - latitudeLowerBound);
        Double longitude = longitudeLowerBound + random.nextDouble() * (longitudeUpperBound - longitudeLowerBound);

        return new Location(latitude, longitude);
    }
}
