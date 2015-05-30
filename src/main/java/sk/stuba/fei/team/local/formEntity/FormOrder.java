package sk.stuba.fei.team.local.formEntity;

import sk.stuba.fei.team.local.domain.Office;
import sk.stuba.fei.team.local.domain.Patient;

import java.util.Date;

/**
 * Created by jakubrehak on 10/05/15.
 */
public class FormOrder {
   // private Patient patient;
    private Long office_id;
    private String date;
    private int intervalStart;
    private String note;

//    public Patient getPatient() {
//        return patient;
//    }
//
//    public void setPatient(Patient patient) {
//        this.patient = patient;
//    }


    public Long getOffice_id() {
        return office_id;
    }

    public void setOffice_id(Long office_id) {
        this.office_id = office_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getIntervalStart() {
        return intervalStart;
    }

    public void setIntervalStart(int intervalStart) {
        this.intervalStart = intervalStart;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
