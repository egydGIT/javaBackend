package interfaces.animal;

import java.util.ArrayList;
import java.util.List;

public class Zoo {

    private List<Animal> animals;

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public int getNumberOfLegs() {
        int legs = 0;
        for (Animal animal : animals) {
            legs += animal.getNumberOfLegs();
        }
        return legs;
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        /*
        animals.add(new Duck(2, "Duck"));
        animals.add(new Lion(4, "Lion"));
        animals.add(new Worm(0, "Warm"));
         */
        animals.add(new Duck());               // Animal if mögé van elrejtve a 3 osztály
        animals.add(new Lion());
        animals.add(new Worm());

        Zoo zoo = new Zoo(animals);             // Zoo példány nem közvetlenül az oszt-ra hivatkozik, hanem az Animal if-re
                                                // if mögött az implementáció cserélhető

        System.out.println(zoo.getNumberOfAnimals());      // 3
        System.out.println(zoo.getNumberOfLegs());         // 6
    }

}
