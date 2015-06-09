package sk.stuba.fei.team.global.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.service.EmployeeService;

import java.text.ParseException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/ws/employee")
public class EmployeeApi {

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
    public List<Employee> update(@RequestBody UpdateWrapper<String> wrapper) throws ParseException {
        return employeeService.findSelectedByTimestamp(wrapper.getTimestamp(), new HashSet<String>(wrapper.getIds()));
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestBody Employee emp) {
        employeeService.save(emp);

        return emp.getUsername();
    }
}
