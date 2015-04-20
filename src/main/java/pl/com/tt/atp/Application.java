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

    public static void main(String[] args) {

        Random rand = new Random();

        RandomSpeedGenerator randomSpeedGenerator = new RandomSpeedGenerator(rand, 200);
        RandomLocationGenerator randomLocationGenerator = new RandomLocationGenerator(rand, -73.0, -72.0, 41.0, 42.0);
        MeasurementProvider measurementProvider = new RandomMeasurementProvider(randomSpeedGenerator, randomLocationGenerator);

        while(true) {
            System.out.println(measurementProvider.getLatestMeasurement());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }

    }
}
