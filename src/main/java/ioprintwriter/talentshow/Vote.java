package ioprintwriter.talentshow;

public class Vote {

    private long id;
    private int number;

    public Vote(long id, int number) {
        this.id = id;
        this.number = number;
    }

    public void incNum() {
        number++;
    }

    public long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }
}
