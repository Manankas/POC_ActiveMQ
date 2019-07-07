package com.tsiry.project.Service;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = "${destination.topic}")
    public void receive1(String message) {
        LOGGER.info("'subscriber1' received message='{}'", message);
    }

    @JmsListener(destination = "${destination.topic}")
    public void receive2(String message) {
        LOGGER.info("'subscriber2' received message='{}'", message);
    }
}