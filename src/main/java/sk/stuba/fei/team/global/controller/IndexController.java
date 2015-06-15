package sk.stuba.fei.team.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping("/")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "WeCare - online objednávanie");

        return "index";
    }

    @RequestMapping("/mail")
    @ResponseStatus(HttpStatus.CREATED)
    SimpleMailMessage send() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("someone@localhost");
        mailMessage.setReplyTo("someone@localhost");
        mailMessage.setFrom("someone@localhost");
        mailMessage.setSubject("Lorem ipsum");
        mailMessage.setText("Lorem ipsum dolor sit amet [...]");
        mailSender.send(mailMessage);
        return mailMessage;
    }
}
