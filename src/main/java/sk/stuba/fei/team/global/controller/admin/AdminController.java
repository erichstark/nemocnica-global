package sk.stuba.fei.team.global.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/admin")
    public String index(Map<String, Object> model) {
        model.put("pageTitle", messageSource.getMessage("dashboard",null, LocaleContextHolder.getLocale()));
        return "admin/index";
    }
}
