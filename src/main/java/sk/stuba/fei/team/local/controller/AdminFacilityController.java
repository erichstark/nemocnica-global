package sk.stuba.fei.team.local.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.local.domain.Facility;
import sk.stuba.fei.team.local.service.FacilityService;

import java.util.Map;

/**
 * Created by pallo on 5/3/15.
 */
@Controller
@RequestMapping("/admin/facility")
public class AdminFacilityController {

    @Autowired
    private FacilityService facilityService;

    @RequestMapping("")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Ambulancia");
        model.put("facilities", facilityService.findAll());

        return "admin/facility/index";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> model) {

        model.put("pageTitle", "Admin Facilities");
        model.put("facility", new Facility());

        return "admin/facility/add";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Map<String, Object> model) {

        model.put("pageTitle", "Admin Facilities");
        model.put("facility", facilityService.findOne(id));

        return "admin/facility/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("facility") Facility facility, Map<String, Object> model) {

        facilityService.save(facility);

        return "redirect:/admin/facility";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Map<String, Object> model) {

        facilityService.delete(id);

        return "redirect:/admin/facility";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, params = {"text"})
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Facility> facilities = facilityService.findByName(text);

        model.put("pageTitle", "Admin Facilities");
        model.put("search", text);
        model.put("facilities", facilities);

        return "admin/facility/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Admin Facilities");
        model.put("facilities", facilityService.findAll());

        return "admin/facility/index";
    }
}
