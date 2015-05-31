package sk.stuba.fei.team.local.calendar;

/**
 * Created by jakubrehak on 08/05/15.
 */
public class Interval {
    private int s;
    private int e;
    private int free;

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
}
