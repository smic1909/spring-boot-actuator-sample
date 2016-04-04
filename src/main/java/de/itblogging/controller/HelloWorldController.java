package de.itblogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private CounterService counterService;

    @Autowired
    private GaugeService gaugeService;

    @RequestMapping(path = "/helloworld", method = RequestMethod.GET)
    public String helloWorld() {
        counterService.increment("helloworld");
        gaugeService.submit("helloworld.last.call", System.currentTimeMillis());
        return "Hello World";
    }

    @RequestMapping(path = "/helloactuator", method = RequestMethod.GET)
    public String helloActuator() {
        counterService.increment("helloactuator");
        gaugeService.submit("helloactuator.last.call", System.currentTimeMillis());
        return "Hello Actuator";
    }
}
