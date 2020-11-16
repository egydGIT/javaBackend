package intromethods.todo;

public class ToDo {
    private String caption;
    private boolean finished;

    public ToDo(String caption) {
        this.caption = caption;
    }

    public void finish() {
        finished = true;
    }

    public void todo(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public boolean isFinished() {
        return finished;
    }

    @Override
    public String toString() {
        return caption + " (" + (finished ? "finished" : "not finished") + ")";
    }

}
