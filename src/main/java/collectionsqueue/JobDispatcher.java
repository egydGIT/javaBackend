package collectionsqueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {

    public Queue<Job> addJob(Job... jobs) {
        return new PriorityQueue<>(Arrays.asList(jobs));      // elemekhez prioritást rendel, duplikáció megengedett
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            // throw new NoJobException("You have no more duty now!");
            throw new NoJobException("No job available, get a rest!");      // saját kivétel
        }
        return jobs.poll();                             // eltávolít a sor elejéről, ha nem sikerül vissz-i értéke null
    }


}
