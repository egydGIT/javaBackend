package interfaces.simplethread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleThread implements Runnable {

    private List<String> tasks;

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void run() {
        while (!tasks.isEmpty()) {
            nextStep();
        }
    }

    private void nextStep() {
		if (tasks != null && !tasks.isEmpty()) {
			tasks.remove(tasks.size() - 1);
		}
	}

    private boolean nextStepMy() {
        if (tasks != null && !tasks.isEmpty()) {
            tasks.remove(tasks.size() - 1);
            return true;
        }
        return false;
    }

    public List<String> getTasks() {
        return tasks;
    }


    public static void main(String[] args) {

        // List<String> tasks = Arrays.asList("GitHub", "cook", "candle");
                        // simpleThread.run();      ->  UnsupportedOperationException   ??
        List<String> tasks = new ArrayList<>();
        tasks.add("GitHub");
        tasks.add("cook");
        tasks.add("candle");
        SimpleThread simpleThread = new SimpleThread(tasks);

        System.out.println(simpleThread.getTasks());
        System.out.println(simpleThread.getTasks().size());
        simpleThread.run();
        System.out.println(simpleThread.getTasks());
    }
}
