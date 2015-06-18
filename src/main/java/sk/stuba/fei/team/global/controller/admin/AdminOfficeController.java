package sk.stuba.fei.team.global.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sk.stuba.fei.team.global.domain.Office;
import sk.stuba.fei.team.global.domain.OpeningHours;
import sk.stuba.fei.team.global.service.OfficeService;

import java.util.*;

/**
 * Created by pallo on 5/2/15.
 */
@Controller
@RequestMapping("/admin/office")
public class AdminOfficeController {

    @Autowired
    private OfficeService officeService;
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Map<String, Object> model) {

        model.put("pageTitle", messageSource.getMessage("offices",null, LocaleContextHolder.getLocale()));
        model.put("offices", officeService.findAll());

        return "admin/office/index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detail/{id}")
    public String detail(@PathVariable Long id, Map<String, Object> model) {

        Office o = officeService.findOne(id);
        List<OpeningHours> hours = new ArrayList<>(o.getHours());
        Comparator<OpeningHours> cmp = new Comparator<OpeningHours>() {
            public int compare(OpeningHours oh1, OpeningHours oh2) {
                return Integer.valueOf(oh1.getDate()).compareTo(Integer.valueOf(oh2.getDate()));
            }
        };
        Collections.sort(hours,cmp);

        model.put("hours",hours);
        model.put("office", o);
        model.put("pageTitle", "Detail " + o.getName());

        return "admin/office/detail";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Office> offices;
        if (text == "")
            offices = officeService.findAll();
        else
            offices = officeService.findByName(text);

        model.put("pageTitle", messageSource.getMessage("offices",null, LocaleContextHolder.getLocale()));
        model.put("search", text);
        model.put("offices", offices);

        return "admin/office/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", messageSource.getMessage("offices",null, LocaleContextHolder.getLocale()));
        model.put("offices", officeService.findAll());

        return "admin/office/index";
    }


}
