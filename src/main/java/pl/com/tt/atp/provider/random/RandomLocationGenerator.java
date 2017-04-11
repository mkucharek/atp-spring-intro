package pl.com.tt.atp.provider.random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.com.tt.atp.measurement.Location;

import java.util.Random;

/**
 * @author mkucharek
 */
@Component
class RandomLocationGenerator {

    private final Random random;

    @Value("${provider.random.latitude.bound.lower:-71.0}")
    private Double latitudeLowerBound;

    @Value("${provider.random.latitude.bound.upper:-70.0}")
    private Double latitudeUpperBound;

    @Value("${provider.random.longitude.bound.lower:41.0}")
    private Double longitudeUpperBound;

    @Value("${provider.random.longitude.bound.upper:42.0}")
    private Double longitudeLowerBound;

    @Autowired
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
