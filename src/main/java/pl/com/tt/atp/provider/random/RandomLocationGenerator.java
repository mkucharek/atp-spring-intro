package pl.com.tt.atp.provider.random;

import pl.com.tt.atp.measurement.Location;

import java.util.Random;

/**
 * @author mkucharek
 */
public class RandomLocationGenerator {

    private final Random random;

    private Double latitudeLowerBound;
    private Double latitudeUpperBound;
    private Double longitudeUpperBound;
    private Double longitudeLowerBound;

    public RandomLocationGenerator(Random random) {
        this.random = random;
    }

    public void setLatitudeLowerBound(Double latitudeLowerBound) {
        this.latitudeLowerBound = latitudeLowerBound;
    }

    public void setLatitudeUpperBound(Double latitudeUpperBound) {
        this.latitudeUpperBound = latitudeUpperBound;
    }

    public void setLongitudeUpperBound(Double longitudeUpperBound) {
        this.longitudeUpperBound = longitudeUpperBound;
    }

    public void setLongitudeLowerBound(Double longitudeLowerBound) {
        this.longitudeLowerBound = longitudeLowerBound;
    }

    public Location getRandomLocation() {
        Double latitude = latitudeLowerBound + random.nextDouble() * (latitudeUpperBound - latitudeLowerBound);
        Double longitude = longitudeLowerBound + random.nextDouble() * (longitudeUpperBound - longitudeLowerBound);

        return new Location(latitude, longitude);
    }
}
