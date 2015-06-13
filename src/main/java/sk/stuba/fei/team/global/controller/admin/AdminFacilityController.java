package sk.stuba.fei.team.global.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.domain.Facility;
import sk.stuba.fei.team.global.service.FacilityService;

import java.util.Map;

/**
 * Created by pallo on 5/3/15.
 */
@Controller
@RequestMapping("/admin/facility")
public class AdminFacilityController {

    @Autowired
    private FacilityService facilityService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Ambulancia");
        model.put("facilities", facilityService.findAll());

        return "admin/facility/index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
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
