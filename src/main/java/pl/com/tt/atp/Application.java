package pl.com.tt.atp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.com.tt.atp.measurement.MeasurementProvider;
import pl.com.tt.atp.provider.random.RandomLocationGenerator;
import pl.com.tt.atp.provider.random.RandomSpeedGenerator;

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

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        final RandomSpeedGenerator randomSpeedGenerator = ctx.getBean(RandomSpeedGenerator.class);
        randomSpeedGenerator.setSpeedUpperBound(DEFAULT_SPEED_UPPER_BOUND);

        final RandomLocationGenerator randomLocationGenerator = ctx.getBean(RandomLocationGenerator.class);
        randomLocationGenerator.setLatitudeLowerBound(DEFAULT_LATITUDE_LOWER_BOUND);
        randomLocationGenerator.setLatitudeUpperBound(DEFAULT_LATITUDE_UPPER_BOUND);
        randomLocationGenerator.setLongitudeLowerBound(DEFAULT_LONGITUDE_LOWER_BOUND);
        randomLocationGenerator.setLongitudeUpperBound(DEFAULT_LONGITUDE_UPPER_BOUND);


        MeasurementProvider measurementProvider = ctx.getBean(MeasurementProvider.class);

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
