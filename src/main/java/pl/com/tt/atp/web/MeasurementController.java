package pl.com.tt.atp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.tt.atp.measurement.Measurement;
import pl.com.tt.atp.measurement.MeasurementProvider;

import java.util.List;

/**
 * @author mkucharek
 */
@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    @Autowired
    private MeasurementProvider measurementProvider;

    @RequestMapping("latest")
    public Measurement getLatestMeasurement() {
        return measurementProvider.getLatestMeasurement();
    }
}
