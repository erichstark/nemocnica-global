package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.service.EmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ws/employee")
public class EmployeeApiController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Employee findByUsername(@PathVariable String username) {
        Employee emp = employeeService.findOne(username);
        if(emp != null) {
            emp.setOffices(Collections.emptySet());
        }
        return emp;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<Employee> update(@RequestParam String timestamp, @RequestBody Set<String> usernames) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        Date dateObj = sdf.parse(timestamp);
        return employeeService.findSelectedByTimestamp(dateObj, usernames);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestBody Employee emp) {
        employeeService.save(emp);

        return emp.getUsername();
    }
}
