package pl.com.tt.atp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Random;

/**
 * @author mkucharek
 */
@Configuration
@ComponentScan
@PropertySource("classpath:/app.properties")
public class AppConfig {

    @Bean
    public Random getRandom() {
        return new Random();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigIn() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
