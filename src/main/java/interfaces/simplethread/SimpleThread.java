package interfaces.simplethread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleThread implements Runable{

    private List<String> tasks = new ArrayList<>();

    public SimpleThread(List<String> tasks) {
        this.tasks = tasks;
    }

    public List<String> getTasks() {
        return tasks;
    }

/*
    @Override                                           // saját
    public void run() {
        while (!tasks.isEmpty()) {
            nextStep();
        }
    }

    private List<String> nextStep() {
        if (!tasks.isEmpty()) {                         // .get(), .contains() nem boolean-el térnek vissza
            tasks.remove(tasks.size()-1);
        }
        return tasks;
    }

 */

	@Override                                            // solution
	public void run() {
		while(!tasks.isEmpty()) {
			nextStep();
		}
	}

    private void nextStep() {
		if (tasks != null && !tasks.isEmpty()) {
			tasks.remove(tasks.size() - 1);
		}
	}



    public static void main(String[] args) {

        List<String> tasks = Arrays.asList("GitHub", "cook", "candle");
        SimpleThread simpleThread = new SimpleThread(tasks);

        System.out.println(tasks);
        // System.out.println(simpleThread.run());                 // java: 'void' type not allowed here
        // System.out.println(simpleThread.nextStep());            // java: 'void' type not allowed here
    }
}
