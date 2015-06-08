package sk.stuba.fei.team.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "WeCare - online objednávanie");

        return "index";
    }
}