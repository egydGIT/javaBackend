package week15d04;

public class CovidCasesByWeek implements Comparable<CovidCasesByWeek>{

    private String week;
    private int cases;

    public CovidCasesByWeek(String name, int cases) {
        this.week = name;
        this.cases = cases;
    }

    public String getWeek() {
        return week;
    }

    public int getCases() {
        return cases;
    }

    @Override
    public String toString() {
        return '\n' + "CovidCasesByWeek{" +
                "name='" + week + '\'' +
                ", cases=" + cases +
                '}';
    }

    @Override
    public int compareTo(CovidCasesByWeek o) {
        return o.cases - this.cases;
    }
}
