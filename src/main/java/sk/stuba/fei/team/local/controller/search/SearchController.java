package sk.stuba.fei.team.local.controller.search;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.team.local.calendar.Day;
import sk.stuba.fei.team.local.calendar.Interval;
import sk.stuba.fei.team.local.domain.*;
import sk.stuba.fei.team.local.formEntity.FormEmployeeSearch;
import sk.stuba.fei.team.local.formEntity.FormOrder;
import sk.stuba.fei.team.local.service.*;

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
    List<PatientOrder> objednavky;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OfficeService officeService;

    @Autowired
    private HoursService hoursService;

    @Autowired
    private PatientOrderService orderService;

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
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
            for (PatientOrder temp : objednavky) {

                if(temp.getIntervalStart() == s.intValue()+j*interval){
                    in.setFree(0);
                }
            }
            intervals.add(j,in);
            j++;
        }


        return intervals;
    }
    public List<Day> fillListOfDays(Long id,Long officeid){

        Employee emp  = employeeService.findOne(id);
        Office office = officeService.findOne(officeid);
        Iterable<Hours> hodiny;
        //hodiny= hoursService.findByEmployeeId(id);
        hodiny= hoursService.findByEmployeeIdAndOfficeId(id,officeid);


        List<Day> dayList= new ArrayList<>();

        for(int i=0; i<=83; i++){
            Calendar c= Calendar.getInstance();

            c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 1);

            //SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
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

            for (Hours it : hodiny) {
                String d1=dayList.get(i).getDate();

                SimpleDateFormat dt = new SimpleDateFormat("d.M.yyyy");
                String d2 =    dt.format(it.getDate());

                if(d2.equals( d1 )){


                    dayList.get(i).setText("je v DB");
                    dayList.get(i).setHour(it);
                    dayList.get(i).setIntervalList(calculateInterval(it.getDate().toString(),office ,it.getReservationFrom(),it.getReservationTo()));

                }
            }

        }
        return dayList;
    }


//    @ModelAttribute("searchUser")
//    public FormEmployeeSearch getAmbulancieSearchForm() {
//        FormEmployeeSearch ambulancieSearchForm = new FormEmployeeSearch();
//        ambulancieSearchForm.setSortField("lastName");
//        ambulancieSearchForm.setSortOrder("DESC");
//        return ambulancieSearchForm;
//    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search( @ModelAttribute("searchUser") FormEmployeeSearch search, Map<String, Object> model ) {


        Iterable<Employee> zoznam;
        zoznam = employeeService.findAll();
        if (search.getName() == "" && search.getSurname() == "" && search.getSpecialization() == "" && search.getTown() == "" ){
            zoznam = employeeService.findAll();
        } else {
            zoznam = employeeService.findDoctors(search.getName(),search.getSurname(),search.getSpecialization(),search.getTown());

        }



// spravit vyhladavanie tak ze specializacia bude jeden dlhyy string

        model.put("pageTitle", "Vyhľadávanie lekárov");
        model.put("name", search.getName());
        model.put("surname", search.getSurname());
        model.put("specialization", search.getSpecialization());
        model.put("town", search.getTown());
        model.put("employees", zoznam);

        return "search/index";
    }

    @RequestMapping(value = "/detail/{id}/{officeid}")
    public String detail(@PathVariable Long id, @PathVariable Long officeid , Map<String, Object> model) {

        Employee emp  = employeeService.findOne(id);
        Office office = officeService.findOne(officeid);

        List<Day> dayList= fillListOfDays(id,officeid);


        model.put("pageTitle", "Vyhľadávanie lekárov");
        model.put("days",dayList);
        model.put("order", new PatientOrder());
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

        PatientOrder newOrd = new PatientOrder();

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
