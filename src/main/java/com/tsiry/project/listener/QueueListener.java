package com.tsiry.project.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Component
public class QueueListener {

    @JmsListener(destination = "poc_inbound.queue")
    @SendTo("poc_outbound.queue")
    public String receiveMessage(final Message jsonMessage) throws JMSException {
        String messageData = null;
        System.out.println("Received message " + jsonMessage);
        String response = jsonMessage.getPayload().toString();
        return response;  // will be sent to "poc_outbound.queue"
    }

}
