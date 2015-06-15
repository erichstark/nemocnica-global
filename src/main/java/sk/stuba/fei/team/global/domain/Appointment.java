package sk.stuba.fei.team.global.domain;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@XmlRootElement
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1421512442419014237L;
    private Long id;
    private Patient patient;
    private Office office;
    private Date date;
    private int intervalStart;
    private String note;
    private Date updated;

    public Appointment() {
        intervalStart = 0;
        note = "";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "patient", nullable = false)
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @ManyToOne
    @JoinColumn(name = "office", nullable = false)
    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    @Column
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    @Column
    public int getIntervalStart() {
        return intervalStart;
    }

    public void setIntervalStart(int intervalStart) {
        this.intervalStart = intervalStart;
    }

    @Column
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
