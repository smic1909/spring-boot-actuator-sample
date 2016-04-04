package de.itblogging.metrics;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ItbloggingHealth implements HealthIndicator {
    
    @Override
    public Health health() {

        try{
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getForObject("http://www.itblogging.de", String.class);
            return Health.up().build();
        }catch (Exception e){
            return Health.down(e).build();
        }
    }
}
