package sk.stuba.fei.team.global.calendar;

import sk.stuba.fei.team.global.domain.Hours;

import java.util.List;

/**
 * Created by jakubrehak on 07/05/15.
 */
public class Day {
    private Hours hour;
    private String date;
    private String day;
    private String text;
    private List<Interval> intervalList;


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

    public Hours getHour() {
        return hour;
    }

    public void setHour(Hours hour) {
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
}
