package sk.stuba.fei.team.global.calendar;

/**
 * Created by jakubrehak on 08/05/15.
 */
public class Interval {
    private int s;
    private int e;
    private int sM;
    private int eM;
    private int free;
    private int freeM;

    public Interval(int in, int s) {
        this.s = s;
        this.e = s+in;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }


    public int getsM() {
        return sM;
    }

    public void setsM(int sM) {
        this.sM = sM;
    }

    public int geteM() {
        return eM;
    }

    public void seteM(int eM) {
        this.eM = eM;
    }

    public int getFreeM() {
        return freeM;
    }

    public void setFreeM(int freeM) {
        this.freeM = freeM;
    }
}
