package sk.stuba.fei.team.global.controller.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.team.global.domain.Appointment;
import sk.stuba.fei.team.global.domain.Patient;
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

    @RequestMapping("{username}")
    public String index(@PathVariable String username,Map<String, Object> model) {

        Patient patient= patientService.findByUsername(username);
        Iterable<Appointment> orders= orderService.findByPatient(patient);
        model.put("pageTitle", "moje objednavky");
        model.put("orders", orders);
        model.put("patient",patient);

        return "order/index";
    }

    @RequestMapping("/delete/{username}/{order_id}")
    public String delete(@PathVariable String username,@PathVariable Long order_id , Map<String, Object> model) {

      Appointment appointment = orderService.findById(order_id);
        Patient patient= patientService.findByUsername(username);
        Iterable<Appointment> orders= orderService.findByPatient(patient);

        model.put("orders", orders);
        model.put("patient",patient);
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
            orderService.delete(order_id);
            model.put("message","ok");
            return "/appointment/"+username;


        }



        model.put("chcemzrusit", c.getTime().toString());
        model.put("den",cal.getTime().toString());
        model.put("pageTitle","fff");
        model.put("message","fail");
        return "/appointment/"+username;
    }
}
