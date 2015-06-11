package sk.stuba.fei.team.global.api.domain;

import sk.stuba.fei.team.global.domain.Appointment;

import java.util.Date;

public class AppointmentWrapper {

    private Long id;
    private String patient;
    private Long office;
    private Date date;
    private int intervalStart;
    private String note;

    public AppointmentWrapper() {
    }

    public AppointmentWrapper(Appointment appointment) {
        id = appointment.getId();
        patient = appointment.getPatient().getUsername();
        office = appointment.getOffice().getId();
        date = appointment.getDate();
        intervalStart = appointment.getIntervalStart();
        note = appointment.getNote();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Long getOffice() {
        return office;
    }

    public void setOffice(Long office) {
        this.office = office;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
