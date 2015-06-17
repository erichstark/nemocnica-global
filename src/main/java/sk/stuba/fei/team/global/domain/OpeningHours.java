package sk.stuba.fei.team.global.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
public class OpeningHours implements Serializable {
    private static final long serialVersionUID = -6163945840447837521L;
    private Long Id;
    private int date;
    private Long reservationMorningFrom;
    private Long reservationMorningTo;
    private Long reservationFrom;
    private Long reservationTo;
    private Office office;

    @Id
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    @Column
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
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
    public Long getReservationMorningFrom() {
        return reservationMorningFrom;
    }

    public void setReservationMorningFrom(Long reservationMorningFrom) {
        this.reservationMorningFrom = reservationMorningFrom;
    }

    @Column
    public Long getReservationMorningTo() {
        return reservationMorningTo;
    }

    public void setReservationMorningTo(Long reservationMorningTo) {
        this.reservationMorningTo = reservationMorningTo;
    }

    @Transient
    public String getDayFromDate() {
        switch (date){
            case 1: return "Pondelok";
            case 2: return "Utorok";
            case 3: return "Streda";
            case 4: return "Štvrtok";
            case 5: return "Piatok";
            case 6: return "Sobota";
            case 7: return "Nedeľa";
        }
        return "";
    }
}
