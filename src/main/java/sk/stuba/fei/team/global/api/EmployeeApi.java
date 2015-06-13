package sk.stuba.fei.team.global.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.api.domain.EmployeeWrapper;
import sk.stuba.fei.team.global.api.domain.UpdateWrapper;
import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.service.EmployeeService;
import sk.stuba.fei.team.global.service.SpecializationService;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/ws/employee")
public class EmployeeApi {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    SpecializationService specializationService;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public EmployeeWrapper findByUsername(@PathVariable String username) {
        Employee emp = employeeService.findOne(username);
        if (emp != null)
            return new EmployeeWrapper(emp);
        else
            return null;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<EmployeeWrapper> update(@RequestBody UpdateWrapper<String> wrapper) throws ParseException {
        List<Employee> eList = employeeService.findSelectedByTimestamp(wrapper.getTimestamp(), new HashSet<String>(wrapper.getIds()));
        List<EmployeeWrapper> ewl = new ArrayList<>(eList.size());
        eList.forEach(e -> ewl.add(new EmployeeWrapper(e)));
        return ewl;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestBody EmployeeWrapper ew) throws JsonProcessingException {
        Employee e = ew.build(specializationService, employeeService);
        employeeService.save(e);
        return new ObjectMapper().writeValueAsString(e.getUsername());
    }
}
