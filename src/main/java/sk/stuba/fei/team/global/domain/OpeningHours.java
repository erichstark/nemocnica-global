package sk.stuba.fei.team.global.domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Entity
@XmlRootElement
public class OpeningHours implements Serializable {
    private Long Id;
    private Date date;
    private Long reservationFrom;
    private Long reservationTo;
    private Office office;
    private int free;

    @Id
    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }

    @Column
    @Type(type = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column
    public Long getReservationFrom() {
        return reservationFrom;
    }

    public void setReservationFrom(Long reservationFrom) {
        this.reservationFrom = reservationFrom;
    }

    @Column
    public Long getReservationTo() {
        return reservationTo;
    }

    public void setReservationTo(Long reservationTo) {
        this.reservationTo = reservationTo;
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
    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

}
