package sk.stuba.fei.nemocnica.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model)
    {
		model.addAttribute("wmsg","Welcome");
		return "index";
    }
}
