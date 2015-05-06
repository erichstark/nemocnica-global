package sk.stuba.fei.team.local.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.local.domain.Insurance;
import sk.stuba.fei.team.local.service.InsuranceService;

import java.util.Map;

/**
 * Created by pallo on 5/3/15.
 */
@Controller
@RequestMapping("/admin/insurance")
public class AdminInsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping("")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Insurances");
        model.put("insurances", insuranceService.findAll());

        return "admin/insurance/index";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> model) {

        model.put("pageTitle", "Admin Insurances");
        model.put("insurance", new Insurance());

        return "admin/insurance/add";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Map<String, Object> model) {

        model.put("pageTitle", "Admin Insurances");
        model.put("insurance", insuranceService.findOne(id));

        return "admin/insurance/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("insurance") Insurance insurance, Map<String, Object> model) {

        insuranceService.save(insurance);

        return "redirect:/admin/insurance";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Map<String, Object> model) {

        insuranceService.delete(id);

        return "redirect:/admin/insurance";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, params = {"text"})
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Insurance> offices = insuranceService.findByName(text);

        model.put("pageTitle", "Admin Insurances");
        model.put("search", text);
        model.put("insurances", offices);

        return "admin/insurance/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Admin Insurances");
        model.put("insurances", insuranceService.findAll());

        return "admin/insurance/index";
    }
}
