package sk.stuba.fei.team.global.controller.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.service.*;

import java.util.*;

/**
 * Created by jakubrehak on 06/05/15.
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OpeningHoursService openingHoursService;

    @RequestMapping("")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Zamestnanci");
        model.put("employees", employeeService.findAll());

        return "employee/index";
    }





    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Zamestnanec");
        model.put("employee", employeeService.findAll());

        return "employee/index";
    }

}
