package de.itblogging.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ApplicationContextMetrics implements PublicMetrics {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Collection<Metric<?>> metrics() {
        final List<Metric<?>> metrics = new ArrayList<>();

        metrics.add(new Metric<Number>("spring.context.start-up-date", applicationContext.getStartupDate()));
        metrics.add(new Metric<Number>("spring.context.definition-count", applicationContext.getBeanDefinitionCount()));
        metrics.add(new Metric<Number>("spring.context.beans", applicationContext.getBeanNamesForType(Object.class).length));
        metrics.add(new Metric<Number>("spring.context.controller", applicationContext.getBeanNamesForAnnotation(RestController.class).length));

        return metrics;
    }
}
