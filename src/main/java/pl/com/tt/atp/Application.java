package pl.com.tt.atp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import pl.com.tt.atp.measurement.MeasurementProvider;

import java.util.Random;

/**
 * @author mkucharek
 */

@SpringBootApplication
public class Application {

    public static final long DEFAULT_POLLING_INTERVAL = 1000;

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

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

    @Bean
    public Random getRandom() {
        return new Random();
    }

}
