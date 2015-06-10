package sk.stuba.fei.team.global.api.domain;

import sk.stuba.fei.team.global.domain.OpeningHours;

public class OpeningHoursWrapper {
    private Long id;
    private String date;
    private Long reservationMorningFrom;
    private Long reservationMorningTo;
    private Long reservationFrom;
    private Long reservationTo;
    private Long office;

    public OpeningHoursWrapper() {
    }


    public OpeningHoursWrapper(OpeningHours openingHours) {
        id = openingHours.getId();
        date = openingHours.getDate();
        reservationMorningFrom = openingHours.getReservationMorningFrom();
        reservationMorningTo = openingHours.getReservationMorningTo();
        reservationFrom = openingHours.getReservationFrom();
        reservationTo = openingHours.getReservationTo();
        office = openingHours.getOffice().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getReservationMorningFrom() {
        return reservationMorningFrom;
    }

    public void setReservationMorningFrom(Long reservationMorningFrom) {
        this.reservationMorningFrom = reservationMorningFrom;
    }

    public Long getReservationMorningTo() {
        return reservationMorningTo;
    }

    public void setReservationMorningTo(Long reservationMorningTo) {
        this.reservationMorningTo = reservationMorningTo;
    }

    public Long getReservationFrom() {
        return reservationFrom;
    }

    public void setReservationFrom(Long reservationFrom) {
        this.reservationFrom = reservationFrom;
    }

    public Long getReservationTo() {
        return reservationTo;
    }

    public void setReservationTo(Long reservationTo) {
        this.reservationTo = reservationTo;
    }

    public Long getOffice() {
        return office;
    }

    public void setOffice(Long office) {
        this.office = office;
    }
}
