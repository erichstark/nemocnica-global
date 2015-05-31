package sk.stuba.fei.team.local.controller.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.local.calendar.Day;
import sk.stuba.fei.team.local.calendar.Interval;
import sk.stuba.fei.team.local.domain.Employee;
import sk.stuba.fei.team.local.domain.Hours;
import sk.stuba.fei.team.local.domain.Office;
import sk.stuba.fei.team.local.formEntity.FormEmployeeSearch;
import sk.stuba.fei.team.local.service.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    private HoursService hoursService;

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
