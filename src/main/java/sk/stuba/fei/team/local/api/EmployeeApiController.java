package sk.stuba.fei.team.local.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.team.local.domain.Employee;
import sk.stuba.fei.team.local.service.EmployeeService;

@RestController
@RequestMapping("/ws/employee")
public class EmployeeApiController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Employee> employeesAll() {
        return
                employeeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Long add(@RequestBody Employee emp) {
        employeeService.save(emp);

        return emp.getId();
    }
}
