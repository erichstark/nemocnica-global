package sk.stuba.fei.nemocnica;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsReceiver {

    @JmsListener(destination = "test")
    public void receiveTopicMessage(String message) {
        System.out.println("Received message <" + message + ">");
    }
}
