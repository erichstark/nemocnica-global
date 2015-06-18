package sk.stuba.fei.team.global.controller.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.stuba.fei.team.global.domain.Appointment;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.security.CustomUser;
import sk.stuba.fei.team.global.service.AppointmentService;
import sk.stuba.fei.team.global.service.PatientService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by jakubrehak on 11/05/15.
 */
@Controller
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService orderService;

    @RequestMapping
    public String index(Map<String, Object> model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        CustomUser userDetails = (CustomUser) principal;

        Patient patient= patientService.findByUsername(userDetails.getUsername());
        Iterable<Appointment> orders= orderService.findByPatient(patient);
        model.put("pageTitle", "Moje objednávky");
        model.put("orders", orders);
        model.put("patient",patient);

        return "order/index";
    }

    @RequestMapping("/delete/{order_id}")
    public String delete(@PathVariable Long order_id , RedirectAttributes redirectAttributes) {

        Appointment appointment = orderService.findById(order_id);
        Date d= appointment.getDate();
        Calendar cal = Calendar.getInstance();
        Calendar c= Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DAY_OF_MONTH, -1);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        String db2= formatter.format(cal.getTime());
        String db= formatter.format(c.getTime());
        try {
            cal.setTime(formatter.parse(db2));
            c.setTime(formatter.parse(db));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(cal.getTime().before(c.getTime())){
            appointment.setEnabled(false);
            orderService.save(appointment);
            redirectAttributes.addFlashAttribute("amessage","ok");
            return "redirect:/appointment";
        }
        redirectAttributes.addFlashAttribute("amessage","fail");
        return "redirect:/appointment";
    }
}
