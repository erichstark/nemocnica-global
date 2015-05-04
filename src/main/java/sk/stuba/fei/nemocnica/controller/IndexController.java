package sk.stuba.fei.nemocnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.nemocnica.JmsProducer;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    JmsProducer jmsProducer;

    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("pageTitle", "Hello Title");
        model.put("user", "USER");

        //example of using jms Producer
        jmsProducer.sendTopicMessage("This is message form Topic");
        jmsProducer.sendQueueMessage("This is message from Queue");
        return "index";
    }
}
