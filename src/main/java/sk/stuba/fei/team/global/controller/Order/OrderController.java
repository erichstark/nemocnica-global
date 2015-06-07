package sk.stuba.fei.team.global.controller.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.stuba.fei.team.global.domain.Patient;
import sk.stuba.fei.team.global.domain.Order;
import sk.stuba.fei.team.global.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("")
    public String index(Map<String, Object> model) {

        Patient patient= patientService.findByUsername("admin");
        Iterable<Order> orders= orderService.findByPatient(patient);
        model.put("pageTitle", "moje objednavky");
        model.put("orders", orders);
        model.put("patient",patient);

        return "order/index";
    }

    @RequestMapping("/delete/{order_id}")
    public String delete(@PathVariable Long order_id , Map<String, Object> model) {

      Order order= orderService.findById(order_id);

      Date d=order.getDate();

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
            return "redirect:/order";


        }



        model.put("chcemzrusit", c.getTime().toString());
        model.put("den",cal.getTime().toString());
        model.put("pageTitle","fff");
        return "order/test";
    }
}
