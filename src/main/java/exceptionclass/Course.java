package exceptionclass;

public class Course {

    private String name;

    private SimpleTime begin;

    public Course(String name, SimpleTime begin) {
        if (name == null) {
            throw new IllegalArgumentException("Invalid course name.");
        }
        if (begin == null) {
            throw new IllegalArgumentException("Invalid begin.");
        }
        this.name = name;
        this.begin = begin;
    }

    public String getName() {
        return name;
    }

    public SimpleTime getBegin() {
        return begin;
    }

    @Override
    public String toString() {
        return this.getBegin().toString() + " : " + this.getName();
    }
}
