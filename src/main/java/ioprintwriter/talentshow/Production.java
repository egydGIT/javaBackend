package ioprintwriter.talentshow;

public class Production {

    private long id;
    private String name;

    public Production(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
