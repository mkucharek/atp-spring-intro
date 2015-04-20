package pl.com.tt.atp;

import pl.com.tt.atp.measurement.MeasurementProvider;
import pl.com.tt.atp.provider.random.RandomLocationGenerator;
import pl.com.tt.atp.provider.random.RandomMeasurementProvider;
import pl.com.tt.atp.provider.random.RandomSpeedGenerator;

import java.util.Random;

/**
 * @author mkucharek
 */
public class Application {

    public static final int DEFAULT_SPEED_UPPER_BOUND = 200;
    public static final double DEFAULT_LATITUDE_LOWER_BOUND = -73.0;
    public static final double DEFAULT_LATITUDE_UPPER_BOUND = -72.0;
    public static final double DEFAULT_LONGITUDE_LOWER_BOUND = 41.0;
    public static final double DEFAULT_LONGITUDE_UPPER_BOUND = 42.0;

    public static final long DEFAULT_POLLING_INTERVAL = 1000;

    public static void main(String[] args) {

        // TODO: get the configuration from properties file / command line ?
        // additional 50 lines or so..

        Random rand = new Random();

        RandomSpeedGenerator randomSpeedGenerator = new RandomSpeedGenerator(rand);
        randomSpeedGenerator.setSpeedUpperBound(DEFAULT_SPEED_UPPER_BOUND);

        RandomLocationGenerator randomLocationGenerator = new RandomLocationGenerator(rand);
        randomLocationGenerator.setLatitudeLowerBound(DEFAULT_LATITUDE_LOWER_BOUND);
        randomLocationGenerator.setLatitudeUpperBound(DEFAULT_LATITUDE_UPPER_BOUND);
        randomLocationGenerator.setLongitudeLowerBound(DEFAULT_LONGITUDE_LOWER_BOUND);
        randomLocationGenerator.setLongitudeUpperBound(DEFAULT_LONGITUDE_UPPER_BOUND);

        MeasurementProvider measurementProvider =
                new RandomMeasurementProvider(randomSpeedGenerator, randomLocationGenerator);

        renderMeasurementsPeriodically(measurementProvider, DEFAULT_POLLING_INTERVAL);

    }

    private static void renderMeasurementsPeriodically(MeasurementProvider measurementProvider, long period) {
        while(true) {
            System.out.println("Got " + measurementProvider.getLatestMeasurement());
            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

}
