package sk.stuba.fei.team.global.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String index(Map<String, Object> model) {
        model.put("pageTitle", "Admin Dashboard");
        return "admin/index";
    }
}
