package sk.stuba.fei.nemocnica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.nemocnica.domain.Ambulancia;
import sk.stuba.fei.nemocnica.domain.Poistovna;
import sk.stuba.fei.nemocnica.domain.Zariadenie;
import sk.stuba.fei.nemocnica.formEntity.FormAmbulancia;
import sk.stuba.fei.nemocnica.service.AmbulanciaService;
import sk.stuba.fei.nemocnica.service.PoistovnaService;
import sk.stuba.fei.nemocnica.service.ZariadenieService;

import java.util.List;
import java.util.Map;

/**
 * Created by pallo on 5/2/15.
 */
@Controller
@RequestMapping("/admin/ambulancia")
public class AdminAmbulanciaController {

    @Autowired
    private AmbulanciaService ambulanciaService;
    @Autowired
    private ZariadenieService zariadenieService;
    @Autowired
    private PoistovnaService poistovnaService;

    @RequestMapping("")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Admin Ambulancia");
        model.put("ambulancie", ambulanciaService.findAll());

        return "admin/ambulancia/index";
    }

    @RequestMapping(value = "/add")
    public String add(Map<String, Object> model) {

        model.put("pageTitle", "Admin Ambulancia");
        model.put("ambulancia", new Ambulancia());
        model.put("zariadenia", zariadenieService.findAll());
        model.put("poistovne", poistovnaService.findAll());

        return "admin/ambulancia/add";
    }

    @RequestMapping(value = "/edit/{id}")
    public String edit(@PathVariable Long id, Map<String, Object> model) {

        model.put("pageTitle", "Admin Ambulancia");

        Ambulancia amb = ambulanciaService.findOne(id);

        model.put("ambulancia", amb);
        model.put("zariadenia", zariadenieService.findAll());
        model.put("poistovne", poistovnaService.findAll());

        return "admin/ambulancia/edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("ambulancia") FormAmbulancia ambulancia, Map<String, Object> model) {

        Ambulancia newAmb = new Ambulancia();
        if (ambulanciaService.exists(ambulancia.getId())) {
            newAmb = ambulanciaService.findOne(ambulancia.getId());
        } else {
            newAmb.setId(ambulancia.getId());
        }
        newAmb.setName(ambulancia.getName());

        Zariadenie zariadenie = zariadenieService.findOne(ambulancia.getId_zariadenie());
        newAmb.setZariadenie(zariadenie);

        ambulanciaService.save(newAmb);

        return "redirect:/admin/ambulancia";
    }

    @RequestMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id, Map<String, Object> model) {

        ambulanciaService.delete(id);

        return "redirect:/admin/ambulancia";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, params = {"text"})
    public String search(@RequestParam("text") String text, Map<String, Object> model) {

        Iterable<Ambulancia> ambulancie;
        if (text == "")
            ambulancie = ambulanciaService.findAll();
        else
            ambulancie = ambulanciaService.findByName(text);

        model.put("pageTitle", "Admin Ambulancia");
        model.put("search", text);
        model.put("ambulancie", ambulancie);

        return "admin/ambulancia/index";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Admin Ambulancia");
        model.put("ambulancie", ambulanciaService.findAll());

        return "admin/ambulancia/index";
    }

    @RequestMapping(value = "/poistovna/add", method = RequestMethod.POST, params = {"id_poistovna", "id_ambulancia"})
    public String poistovnaAdd(@RequestParam("id_poistovna") Long id_poistovna, @RequestParam("id_ambulancia") Long id_ambulancia) {

        Ambulancia ambulancia = ambulanciaService.findOne(id_ambulancia);
        Poistovna poistovna = poistovnaService.findOne(id_poistovna);

        ambulancia.getPoistovne().add(poistovna);
        poistovna.getAmbulancie().add(ambulancia);

        ambulanciaService.save(ambulancia);

        return "redirect:/admin/ambulancia/edit/" + id_ambulancia;
    }

    @RequestMapping(value = "{id_ambulancia}/poistovna/{id_poistovna}/delete")
    public String poistovnaDelete(@PathVariable("id_ambulancia") Long id_ambulancia, @PathVariable("id_poistovna") Long id_poistovna) {

        Ambulancia ambulancia = ambulanciaService.findOne(id_ambulancia);
        for (Poistovna p : ambulancia.getPoistovne()) {
            if (p.getId() == id_poistovna) {
                ambulancia.getPoistovne().remove(p);
            }
        }

        ambulanciaService.save(ambulancia);

        return "redirect:/admin/ambulancia/edit/" + id_ambulancia;
    }
}
