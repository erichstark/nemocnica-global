package sk.stuba.fei.team.local.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by matwej on 5/31/15.
 */

@RestController
public class TestCtrl {

    @RequestMapping("/ws/hello")
    public String hello() {
        return "Hello";
    }
}
