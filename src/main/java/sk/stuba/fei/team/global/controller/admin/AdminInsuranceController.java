package sk.stuba.fei.team.global.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Insurance;
import sk.stuba.fei.team.global.service.InsuranceService;

import java.util.Map;

/**
 * Created by pallo on 5/3/15.
 */
@Controller
@RequestMapping("/admin/insurance")
public class AdminInsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Insurances");
        model.put("insurances", insuranceService.findAll());

        return "admin/insurance/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String edit(@PathVariable Long id, @RequestParam("name") String name) {

        Insurance in = insuranceService.findOne(id);
        in.setName(name);
        insuranceService.save(in);

        return "redirect:/admin/insurance";
    }

    @RequestMapping(value = "/{id}/enabled", method = RequestMethod.POST)
    public @ResponseBody boolean changeEnabled(@RequestParam Boolean enabled, @PathVariable Long id) {
        Insurance i = insuranceService.findOne(id);
        i.setEnabled(enabled);
        insuranceService.save(i);
        return true;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@RequestParam("name") String name) {

        Insurance in = new Insurance(name);
        in.setEnabled(true);
        insuranceService.save(in);

        return "redirect:/admin/insurance";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
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
