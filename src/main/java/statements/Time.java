package statements;

public class Time {
    int hour1;
    int hour2;
    int minute1;
    int minute2;
    int second1;
    int second2;

/*
    public void getInMinutes1(int hour1, int minute1) {
        int inMinutes1 = 60 * hour1 + minute1;
    }
    public void getInMinutes2(int hour2, int minute2) {
        int inMinutes2 = 60 * hour2 + minute2;
    }
*/

    public void getInSeconds1(int hour1, int minute1, int second1) {
        return int inSeconds1 = 60 * hour1 + 60 * minute1 + second1;
    }

    public void getInSeconds2(int hour2, int minute2, int second2) {
        return int inSeconds2 = 60 * hour2 + 60 * minute2 + second2;
    }

    public void earlierThan() {
        (inSeconds1 < inSeconds2) ? true : false;
        if true {
            System.out.println("Az első dátum korábbi.");
        } else  {
            System.out.println("Az első dátum későbbi.");
        }
    }

}
