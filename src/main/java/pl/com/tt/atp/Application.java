package pl.com.tt.atp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.com.tt.atp.measurement.MeasurementProvider;

/**
 * @author mkucharek
 */

public class Application {

    public static final long DEFAULT_POLLING_INTERVAL = 1000;

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

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
