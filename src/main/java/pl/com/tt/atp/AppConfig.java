package pl.com.tt.atp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

/**
 * @author mkucharek
 */
@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public Random getRandom() {
        return new Random();
    }
}
