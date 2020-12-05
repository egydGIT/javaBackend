package algorithmsmax.trainer;

import java.util.ArrayList;
import java.util.List;

public class MaxAgeCalculator {
    public Trainer TrainerWithMaxAge(List<Trainer> trainers) {
        Trainer trainerFinder = null;
        for (Trainer trainer: trainers) {
            if (trainerFinder == null || trainer.getAge() > trainerFinder.getAge()) {
                trainerFinder = trainer;
            }
        }
        return trainerFinder;
    }

    public static void main(String[] args) {
        Trainer trainer1 = new Trainer("Jack Smith", 45);
        Trainer trainer2 = new Trainer("Kate Thomson", 28);
        Trainer trainer3 = new Trainer("Greg Robinson", 51);

        List<Trainer> trainers = new ArrayList<>();
        trainers.add(trainer1);
        trainers.add(trainer2);
        trainers.add(trainer3);

        System.out.println(new MaxAgeCalculator().TrainerWithMaxAge(trainers).getName());
    }
}
