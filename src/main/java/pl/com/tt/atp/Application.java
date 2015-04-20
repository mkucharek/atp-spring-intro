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

    public static final int SPEED_UPPER_BOUND = 200;
    public static final double LATITUDE_LOWER_BOUND = -73.0;
    public static final double LATITUDE_UPPER_BOUND = -72.0;
    public static final double LONGITUDE_LOWER_BOUND = 41.0;
    public static final double LONGITUDE_UPPER_BOUND = 42.0;

    public static final long POLLING_INTERVAL = 1000;

    public static void main(String[] args) {

        // TODO: get the configuration from properties file / command line ?
        // additional 50 lines or so..

        Random rand = new Random();

        RandomSpeedGenerator randomSpeedGenerator = new RandomSpeedGenerator(rand, SPEED_UPPER_BOUND);
        RandomLocationGenerator randomLocationGenerator = new RandomLocationGenerator(rand,
                LATITUDE_LOWER_BOUND, LATITUDE_UPPER_BOUND, LONGITUDE_LOWER_BOUND, LONGITUDE_UPPER_BOUND);

        MeasurementProvider measurementProvider =
                new RandomMeasurementProvider(randomSpeedGenerator, randomLocationGenerator);

        renderMeasurementsPeriodically(measurementProvider, POLLING_INTERVAL);

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
