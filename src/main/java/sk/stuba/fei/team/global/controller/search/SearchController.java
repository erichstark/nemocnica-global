package sk.stuba.fei.team.global.controller.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.global.calendar.Day;
import sk.stuba.fei.team.global.calendar.Interval;
import sk.stuba.fei.team.global.domain.*;
import sk.stuba.fei.team.global.formEntity.FormEmployeeSearch;
import sk.stuba.fei.team.global.formEntity.FormOrder;
import sk.stuba.fei.team.global.service.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jakubrehak on 10/05/15.
 */
@Controller
@RequestMapping("/search")
public class SearchController {
    List<Appointment> objednavky;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private OpeningHoursService openingHoursService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PatientService patientService;


    @RequestMapping("")
    public String index(Map<String, Object> model) {

        model.put("pageTitle", "Vyhľadávanie lekárov");
        model.put("employees", employeeService.findAll());

        return "search/index";
    }

    public List<Interval> calculateInterval(String date,Office office, Long s, Long e){

        //TODO doplnit interval do databazy

        int interval=30;
        List<Interval> intervals= new ArrayList<>();
        int j=0;

        String d = date;

        DateFormat format = new SimpleDateFormat("d.M.yyyy");
        Date da = null;
        try {
            da = format.parse(d);
        } catch (ParseException e1) {

            e1.printStackTrace();
        }

        objednavky= orderService.findByDateAndOffice(da, office);


        for(int i=s.intValue(); i<e.intValue(); i+=interval){

            Interval in=new Interval(interval, s.intValue()+j*interval);
            in.setFree(1);
            for (Appointment temp : objednavky) {

                if(temp.getIntervalStart() == s.intValue()+j*interval){
                    in.setFree(0);
                }
            }
            intervals.add(j,in);
            j++;
        }


        return intervals;
    }
    public List<Day> fillListOfDays(Long officeid){

        Office office = officeService.findOne(officeid);
        Iterable<OpeningHours> hodiny;
        hodiny= openingHoursService.findByOfficeId(officeid);


        List<Day> dayList= new ArrayList<>();

        for(int i=0; i<=83; i++){
            Calendar c= Calendar.getInstance();

            c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 1);


            SimpleDateFormat dt = new SimpleDateFormat("d.M.yyyy");
            c.add(Calendar.DATE, i);
            String today =dt.format(c.getTime());


            Day d= new Day();
            d.setDate(today);

            Calendar c2 = Calendar.getInstance();
            c2.setTime(c.getTime());
            d.setDay(c2.get(Calendar.DAY_OF_WEEK));
            dayList.add(i, d);
        }

        for (int i=0; i<=83; i++){
            String d1=dayList.get(i).getDay();
            System.out.print(d1 +" porovnava sa s \n ");



            for (OpeningHours it : hodiny) {

                String d2 = it.getDate();
                System.out.print(it +" \n ");
                if(d2.equals( d1 )){


                    dayList.get(i).setText("je v DB");
                    dayList.get(i).setHour(it);
                    dayList.get(i).setIntervalList(calculateInterval(dayList.get(i).getDate(),office ,it.getReservationFrom(),it.getReservationTo()));

                }
            }

        }
        return dayList;
    }



    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search( @ModelAttribute("searchUser") FormEmployeeSearch search, Map<String, Object> model ) {


        Iterable<Office> zoznam;
        zoznam = officeService.findAll();
//        if (search.getName() == "" && search.getSurname() == ""){
//            zoznam = employeeService.findAll();
//        } else {
//            zoznam = employeeService.findDoctors(search.getName(),search.getSurname());
//
//        }



// spravit vyhladavanie tak ze specializacia bude jeden dlhyy string

        model.put("pageTitle", "Vyhľadávanie lekárov");
        model.put("name", search.getName());
        model.put("surname", search.getSurname());
        model.put("offices", zoznam);

        return "search/index";
    }

    @RequestMapping(value = "/detail/{username}/{officeid}")
    public String detail(@PathVariable String username, @PathVariable Long officeid , Map<String, Object> model) {

        Employee emp  = employeeService.findOne(username);
        Office office = officeService.findOne(officeid);


        List<Day> dayList= fillListOfDays(officeid);


        model.put("pageTitle", "Vyhľadávanie lekárov");
        model.put("days",dayList);
        model.put("order", new Appointment());
        model.put("office",office);
        model.put("employee", emp);
        model.put("orders",objednavky);

        return "search/detail";
    }

    @RequestMapping(value = "/clear")
    public String clear(Map<String, Object> model) {
        model.put("pageTitle", "Vyhľadávanie lekárov");
        model.put("employees", employeeService.findAll());

        return "search/index";
    }



    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("order") FormOrder order, Map<String, Object> model) throws ParseException {

        Appointment newOrd = new Appointment();

        Patient p= patientService.findByUsername(order.getUserName());

        String d = order.getDate();
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        Date date = format.parse(d);

        newOrd.setPatient(p);
        newOrd.setDate(date);
        newOrd.setIntervalStart(order.getIntervalStart());
        newOrd.setNote(order.getNote());

        Office office =officeService.findOne(order.getOffice_id());
        newOrd.setOffice(office);


        orderService.save(newOrd);

        model.put("pageTitle", "Vyhľadávanie lekárov");
        return "/search/neworder";
    }
}
