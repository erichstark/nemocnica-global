package sk.stuba.fei.nemocnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.nemocnica.domain.Poistovna;
import sk.stuba.fei.nemocnica.domain.Zariadenie;
import sk.stuba.fei.nemocnica.service.PoistovnaService;

import java.util.Map;

/**
 * Created by pallo on 5/3/15.
 */
@Controller
@RequestMapping("/admin/poistovna")
public class AdminPoistovnaController {

    @Autowired
    private PoistovnaService poistovnaService;

    @RequestMapping("")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Poistovne");
        model.put("poistovne", poistovnaService.findAll());

        return "admin/poistovna/index";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> model) {

        model.put("pageTitle", "Admin Poistovne");
        model.put("poistovna", new Poistovna());

        return "admin/poistovna/add";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Map<String, Object> model) {

        model.put("pageTitle", "Admin Poistovne");
        model.put("poistovna", poistovnaService.findOne(id));

        return "admin/poistovna/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("poistovna") Poistovna poistovna, Map<String, Object> model) {

        poistovnaService.save(poistovna);

        return "redirect:/admin/poistovna";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Map<String, Object> model) {

        poistovnaService.delete(id);

        return "redirect:/admin/poistovna";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, params = {"text"})
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Poistovna> ambulancie = poistovnaService.findByName(text);

        model.put("pageTitle", "Admin Poistovne");
        model.put("search", text);
        model.put("poistovne", ambulancie);

        return "admin/poistovna/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Admin Poistovne");
        model.put("poistovne", poistovnaService.findAll());

        return "admin/poistovna/index";
    }
}
