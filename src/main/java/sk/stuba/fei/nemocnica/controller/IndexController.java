package sk.stuba.fei.nemocnica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {


    @RequestMapping("/")
    public String index(Map<String, Object> model) {
        model.put("pageTitle", "Hello Title");
        model.put("user", "USER");

        return "index";
    }
}
