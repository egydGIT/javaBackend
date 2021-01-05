package week08d01;

import math.game.Point;

import java.util.Locale;

public class Robot {

    /*
    Junior
    A feladatban egy robot mozgását fogjuk szimulálni. Képzelj el egy koordináta rendszert, ahol a robot az origóban van.
    A robot négy irányba képes mozogni fel, le, balra és jobbra. A week08d01.Robot osztályban
    írj egy move() metódust ami egy karaktersorozatot vár. pl: FFLLLLLBBBBJJJJJJJ, ahol az F = fel, L=le, B=bal, J=jobb.
    A metódus visszatérési értéke legyen a robot mozgás utáni pozíciója.
    A feladat szabadon bővíthető osztályokkal és metódusokkal. Bónusz kiegészítés, hogyha más karaktert is tartalmaz a
    paraméter String nem csak a FLBJ valamelyikét, akkor dobjunk IllegalArgumentExceptiont!
     */

    private Position position = new Position(0,0);
    char oneStep;
    String movement;

    public Position move(String movement) {
        movement = movement.toUpperCase();
        for (int i = 0; i < movement.length(); i++) {
            moveOneStep(movement.charAt(i));
        }
        return position;
    }

    public Position moveOneStep(char oneStep) {
        switch (oneStep) {
            case 'F', 'f': {
                position.increaseY();
                return position;
            }
            case 'L', 'l': {
                position.decreaseY();
                return position;
            }
            case 'J', 'j': {
                position.increaseX();
                return position;
            }
            case 'B', 'b': {
                position.decreaseX();
                return position;
            }
            default: {
                throw new IllegalArgumentException("Wrong command!");
            }
        }
    }

    public Position getPosition() {
        return position;
    }

    public static void main(String[] args) {
        Robot robot = new Robot();
        System.out.println(robot.getPosition());
        System.out.println(robot.moveOneStep('f'));
        System.out.println(robot.move("ljjbbffll"));
    }


}
