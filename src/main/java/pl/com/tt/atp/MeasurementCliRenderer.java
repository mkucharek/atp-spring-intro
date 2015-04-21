package pl.com.tt.atp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.com.tt.atp.measurement.MeasurementProvider;

/**
 * @author mkucharek
 */
@Component
public class MeasurementCliRenderer implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(MeasurementCliRenderer.class);

    @Value("${renderer.polling.period}")
    private Long period;

    @Autowired
    private MeasurementProvider measurementProvider;

    @Override
    public void run(String... args) throws Exception {

        LOGGER.info("Arguments are: {}", (Object[]) args);

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
