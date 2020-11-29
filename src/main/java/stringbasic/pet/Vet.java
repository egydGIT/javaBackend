package stringbasic.pet;

import java.util.ArrayList;
import java.util.List;

import static stringbasic.pet.Gender.MALE;
import static stringbasic.pet.Gender.UNKNOWN;

public class Vet {
    public static List<Pet> drBrownPets = new ArrayList<>();

    private static boolean areEqual(Pet newPet) {
        for (int i = 0; i < drBrownPets.size(); i++) {
            if (drBrownPets.get(i).getRegNumber().equals(newPet.getRegNumber())) {
                System.out.println("Already contains.");
                return true;
            }
        }
        System.out.println("New pet can be added.");
        return false;
    }

    public void add(Pet newPet) {
        for (int i = 0; i < drBrownPets.size(); i++) {
            if (areEqual(newPet)) {      // (drBrownPets.get(i).getRegNumber().equals(newPet.getRegNumber())
                break;
            }
        }
        System.out.println("New pet has been added.");
        drBrownPets.add(newPet);
        return;
    }

    public static List<Pet> getDrBrownPets() {
        return drBrownPets;
    }

    public static void main(String[] args) {
        Pet pet1 = new Pet("Tom","2019.10.20", MALE, "000148" );
        Pet pet2 = new Pet("Jerry", "2020.01.14", MALE, "000172" );
        Pet pet3 = new Pet("Tomy", "2019.01.01", UNKNOWN, "000148" );

        System.out.println(drBrownPets.add(pet1));

        System.out.println(areEqual(pet2));
        System.out.println(drBrownPets.add(pet2));

        System.out.println(getDrBrownPets().toString());

        System.out.println(areEqual(pet3));
        System.out.println(drBrownPets.add(pet3));                  // Nem kellene hozzáadnia, mégis hozzáadja. Miért?
        System.out.println(getDrBrownPets().toString());

    }
}
