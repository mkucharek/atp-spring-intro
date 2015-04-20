package pl.com.tt.atp.measurement;

/**
 * @author mkucharek
 */
public class Measurement {

    private final Integer speed;

    private final Location location;

    public Measurement(Integer speed, Location location) {
        this.speed = speed;
        this.location = location;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "speed=" + speed +
                ", location=" + location +
                '}';
    }
}
