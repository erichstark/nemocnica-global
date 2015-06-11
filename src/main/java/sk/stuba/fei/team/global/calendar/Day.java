package sk.stuba.fei.team.global.calendar;

import sk.stuba.fei.team.global.domain.OpeningHours;

import java.util.List;

/**
 * Created by jakubrehak on 07/05/15.
 */
public class Day {
    private OpeningHours hour;
    private String date;
    private String day;
    private String text;
    private List<Interval> intervalList;
    private List<Interval> intervalListMorning;


    public String getDay() {
        return day;
    }

    public void setDay(int d) {

        switch (d){
            case 2: this.day = "Pondelok";
                    break;
            case 3: this.day = "Utorok";
                break;
            case 4: this.day = "Streda";
                break;
            case 5: this.day = "Štvrtok";
                break;
            case 6: this.day = "Piatok";
                break;
            case 7: this.day = "Sobota";
                break;
            case 1: this.day = "Nedeľa";
                break;

            default: this.day = "---";
                        break;

        }


    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public OpeningHours getHour() {
        return hour;
    }

    public void setHour(OpeningHours hour) {
        this.hour = hour;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Interval> getIntervalList() {
        return intervalList;
    }

    public void setIntervalList(List<Interval> intervalList) {
        this.intervalList = intervalList;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Interval> getIntervalListMorning() {
        return intervalListMorning;
    }

    public void setIntervalListMorning(List<Interval> intervalListMorning) {
        this.intervalListMorning = intervalListMorning;
    }
}
