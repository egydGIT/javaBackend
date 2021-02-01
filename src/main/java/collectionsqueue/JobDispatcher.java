package collectionsqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    private PriorityQueue<Job> jobs;

    public JobDispatcher(PriorityQueue<Job> jobs) {
        this.jobs = jobs;
    }

    public Queue<Job> addJob(Job... jobs) {
//        for (Job t: this.jobs) {
//            for (Job j: jobs) {
//                this.jobs.add(j);
//            }
//        }
//        return this.jobs;
        return new PriorityQueue<>(Arrays.asList(jobs));
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("You have no more duty now!");
        }
        return jobs.poll();                     // eltávolít a sor elejéről, ha nem sikerül vissz-i értéke null
    }

    public PriorityQueue<Job> getJobs() {
        return jobs;
    }


}
