package sk.stuba.fei.team.local.controller.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.local.domain.Facility;
import sk.stuba.fei.team.local.domain.Insurance;
import sk.stuba.fei.team.local.domain.Office;
import sk.stuba.fei.team.local.service.FacilityService;
import sk.stuba.fei.team.local.service.InsuranceService;
import sk.stuba.fei.team.local.service.OfficeService;

import java.util.Map;

/**
 * Created by jakubrehak on 06/05/15.
 */

@Controller
@RequestMapping("/office")
public class OfficeController {


    @Autowired
    private OfficeService officeService;
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private InsuranceService insuranceService;

    @RequestMapping("")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Ambulancia");
        model.put("offices", officeService.findAll());

        return "office/index";
    }


    @RequestMapping(value = "/search", method = RequestMethod.POST, params = {"text"})
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Office> offices;
        if (text == "")
            offices = officeService.findAll();
        else
            offices = officeService.findByName(text);

        model.put("pageTitle", "Ambulancie");
        model.put("search", text);
        model.put("offices", offices);

        return "office/index";
    }

    @RequestMapping(value = "/detail/{id}")
    public String detail(@PathVariable Long id, Map<String, Object> model) {

        model.put("pageTitle", "Ambulancia");

        Office off = officeService.findOne(id);

        model.put("office", off);
        model.put("facilities", facilityService.findAll());
        model.put("insurances", insuranceService.findAll());

        return "office/detail";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Admin Ambulancia");
        model.put("offices", officeService.findAll());

        return "office/index";
    }

}
