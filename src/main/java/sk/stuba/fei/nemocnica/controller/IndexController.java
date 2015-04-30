package sk.stuba.fei.nemocnica.controller;

import java.util.Map;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Map<String, Object> model, BindingResult bindingResult)
    {
		model.put("header","Welcome");
		return "index";
    }
}
