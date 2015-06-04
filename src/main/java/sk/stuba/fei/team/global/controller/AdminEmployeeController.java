package sk.stuba.fei.team.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Employee;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.service.EmployeeService;
import sk.stuba.fei.team.global.service.OfficeService;
import sk.stuba.fei.team.global.service.SpecializationService;


import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by pallo on 5/9/15.
 */
@Controller
@RequestMapping("/admin/employee")
public class AdminEmployeeController {

    public static final Logger LOGGER = Logger.getLogger(AdminEmployeeController.class.getName());

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OfficeService officeService;
    @Autowired
    private SpecializationService specializationService;

    @RequestMapping("")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Zamestnanec");
        model.put("employees", employeeService.findAll());

        return "admin/employee/index";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> model) {

        model.put("pageTitle", "Admin Zamestnanec");
        model.put("employee", new Employee());

        return "admin/employee/add";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Map<String, Object> model) {

        Employee employee = employeeService.findOne(id);
        model.put("pageTitle", "Admin Zamestnanec");
        model.put("employee", employee);
        model.put("offices", officeService.findAll());

        return "admin/employee/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("employee") Employee employee) {

        Employee temp = employeeService.findOne(employee.getId());
        employee.setOffices(temp.getOffices());
        employee.setSpecializations(temp.getSpecializations());
        employeeService.save(employee);

        return "redirect:/admin/employee";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/admin/employee";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {

        employeeService.delete(id);

        return "redirect:/admin/employee";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Employee> employees = employeeService.findByFirstnameOrLastname(text);

        model.put("pageTitle", "Admin Zamestnanec");
        model.put("search", text);
        model.put("employees", employees);

        return "admin/employee/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Admin Zamestnanec");
        model.put("employees", employeeService.findAll());

        return "admin/employee/index";
    }

    @RequestMapping(value = "/office/add", method = RequestMethod.POST)
    public String officeAdd(@RequestParam("id_employee") Long id_employee, @RequestParam("id_office") Long id_office) {

        Office office = officeService.findOne(id_office);
        Employee employee = employeeService.findOne(id_employee);

        employee.getOffices().add(office);
        office.getEmployees().add(employee);

        employeeService.save(employee);

        return "redirect:/admin/employee/edit/" + id_employee;
    }

    @RequestMapping(value = "{id_employee}/office/{id_office}/delete")
    public String officeDelete(@PathVariable("id_employee") Long id_employee, @PathVariable("id_office") Long id_office) {

        Employee employee = employeeService.findOne(id_employee);
        Office removeOff = null;
        for (Office o : employee.getOffices()) {
            if (o.getId() == id_office) {
                removeOff = o;
            }
        }

        employee.getOffices().remove(removeOff);
        employeeService.save(employee);

        return "redirect:/admin/employee/edit/" + id_employee;
    }

    @RequestMapping(value = "/specialization/add", method = RequestMethod.POST)
    public String specializationAdd(@RequestParam("id_employee") Long id_employee, @RequestParam("specialization") String specialization) {

        Employee employee = employeeService.findOne(id_employee);
       // employee.getSpecializations().add(specialization);

        employeeService.save(employee);

        return "redirect:/admin/employee/edit/" + id_employee;
    }

    @RequestMapping(value = "{id_employee}/specialization/{specialization}/delete")
    public String specializationDelete(@PathVariable("id_employee") Long id_employee, @PathVariable("specialization") int specialization) {

        Employee employee = employeeService.findOne(id_employee);
       // employee.getSpecializations().remove(specialization);

        employeeService.save(employee);

        return "redirect:/admin/employee/edit/" + id_employee;
    }
}
