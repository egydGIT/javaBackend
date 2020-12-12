package week03d02;

import java.util.ArrayList;
import java.util.List;

public class Position {

    /*
    2020-11-10 (week03d02)
        Írj egy Position osztályt, melynek van egy name és egy bonus attribútuma!
        Egy alkalmazotti pozíciót jelöl, melynek a bonus attribútuma tárolja,
        hogy ebben a pozícióban évente mennyi bónuszt kap egy alkalmazott.
        A main metódusban hozz létre egy Position objektumokat tartalmazo listát!

        Menj végig a lista elemein, és írd ki azokat, ahol a bónusz magasabb, mint 150_000.
        Azonban a kiírás formátumát a Position osztály toString() metódusában implementáld!
     */

    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Position: " + name +
                ", bonus= " + bonus;
    }

    public static void main(String[] args) {
        Position position1 = new Position("secretary", 100_000);
        Position position2 = new Position("lawyer", 200_000);
        Position position3 = new Position("accountant", 150_000);
        Position position4 = new Position("boss", 300_000);

        List<Position> positions = new ArrayList<>();
        positions.add(position1);
        positions.add(position2);
        positions.add(position3);
        positions.add(position4);

        for (Position position: positions) {
            if (position.getBonus() > 150_000) {
                System.out.println(position.toString());
            }
        }
    }
}
