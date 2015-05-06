package sk.stuba.fei.team.local.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.local.domain.Office;
import sk.stuba.fei.team.local.domain.Insurance;
import sk.stuba.fei.team.local.domain.Facility;
import sk.stuba.fei.team.local.formEntity.FormOffice;
import sk.stuba.fei.team.local.service.OfficeService;
import sk.stuba.fei.team.local.service.InsuranceService;
import sk.stuba.fei.team.local.service.FacilityService;

import java.util.Map;

/**
 * Created by pallo on 5/2/15.
 */
@Controller
@RequestMapping("/admin/office")
public class AdminOfficeController {

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

        return "admin/office/index";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> model) {

        model.put("pageTitle", "Admin Ambulancia");
        model.put("office", new Office());
        model.put("facilities", facilityService.findAll());
        model.put("insurances", insuranceService.findAll());

        return "admin/office/add";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Map<String, Object> model) {

        model.put("pageTitle", "Admin Ambulancia");

        Office off = officeService.findOne(id);

        model.put("office", off);
        model.put("facilities", facilityService.findAll());
        model.put("insurances", insuranceService.findAll());

        return "admin/office/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("office") FormOffice office, Map<String, Object> model) {

        Office newAmb = new Office();
        if (officeService.exists(office.getId())) {
            newAmb = officeService.findOne(office.getId());
        } else {
            newAmb.setId(office.getId());
        }
        newAmb.setName(office.getName());

        Facility facility = facilityService.findOne(office.getId_facility());
        newAmb.setFacility(facility);

        officeService.save(newAmb);

        return "redirect:/admin/office";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Map<String, Object> model) {

        officeService.delete(id);

        return "redirect:/admin/office";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, params = {"text"})
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Office> offices;
        if (text == "")
            offices = officeService.findAll();
        else
            offices = officeService.findByName(text);

        model.put("pageTitle", "Admin Ambulancia");
        model.put("search", text);
        model.put("offices", offices);

        return "admin/office/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Admin Ambulancia");
        model.put("offices", officeService.findAll());

        return "admin/office/index";
    }

    @RequestMapping(value = "/insurance/add", method = RequestMethod.POST, params = {"id_insurance", "id_office"})
    public String insuranceAdd(@RequestParam("id_insurance") Long id_insurance, @RequestParam("id_office") Long id_office) {

        Office office = officeService.findOne(id_office);
        Insurance insurance = insuranceService.findOne(id_insurance);

        office.getInsurances().add(insurance);
        insurance.getOffices().add(office);

        officeService.save(office);

        return "redirect:/admin/office/edit/" + id_office;
    }

    @RequestMapping(value = "{id_office}/insurance/{id_insurance}/delete")
    public String insuranceDelete(@PathVariable("id_office") Long id_office, @PathVariable("id_insurance") Long id_insurance) {

        Office office = officeService.findOne(id_office);
        for (Insurance p : office.getInsurances()) {
            if (p.getId() == id_insurance) {
                office.getInsurances().remove(p);
            }
        }

        officeService.save(office);

        return "redirect:/admin/office/edit/" + id_office;
    }
}
