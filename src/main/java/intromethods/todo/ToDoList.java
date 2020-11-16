package intromethods.todo;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private List<ToDo> toDoList = new ArrayList<>();       // 1. lista
    
    public void addToDo(String caption) {          // metódus, ami felvesz egy új tennivalót az 1. listába
        ToDo toDo = new ToDo(caption);             // met-on belüli példányosítás - memóriacímet és nevet ad a feladatnak
        toDoList.add(toDo);                        // újonnan létrehozott feladatot hozzáadja a listához
    }
    
    public void finishToDos(String caption) {           // metódus, ami a paraméterben megkapott értéket összehasonlítja
        for (ToDo todo : toDoList) {                    // for-each ciklus végigiterál az 1. listán
            if (todo.getCaption().equals(caption)) {    // if, a for-e ciklus változójának aktuálisan felvett értékét
                                                            // összehasonlítja a met par-vel
                todo.finish();                          // ha megegyezik a két érték, a lista azon elemére meghívja a
            }                                               // finish() met-t
        }
    }

    public void finishAllTodos(List<String> todosToFinish) {  // egyszerre több tennivalót befejez
                                                                    // param-ként kapja meg a 2. listát
        for (String todoToFinish: todosToFinish) {            // for-e ciklus: deklarál egy változót, ami végigiterál a
                                                                    // kapott befejezendők listáján (2. listán)
            finishToDos(todoToFinish);                        // a lista minden elemére meghívja az előző met-t
        }
    }

    public List<String> todosToFinish() {                   // visszadja a befejezendő tennivalók neveit
        List<String> todosToFinish = new ArrayList<>();     // deklarálja a 2. listát
        for (ToDo todo: toDoList) {                         // for-e cikl. változója végiglépked az 1. listán
            if (!todo.isFinished()) {                       // if, a változó akt. értékére meghívja az isF met-t
                                                                // ha nincs már befejezve, meg tudná rá hívni a met-t
                todosToFinish.add(todo.getCaption());       // a 2. listához hozzáadja a változó aktuális értékét
            }                                                   // ......getC-t miért kell meghíni? ...............??
        }
        return todosToFinish;                               // visszatér a 2. listával
    }

    public int numberOfFinishedTodos() {       // visszaadja a befejezett tennivalók számát
        int sum = 0;                           // változó, amibe elmentjük a tennivalók számát. számolás előtti értéke 0
        for (ToDo todo: toDoList) {            // for-e cikl. változója végiglépked az 1. listán
            if (todo.isFinished()) {           // ha akt értéke már befejezett állapotú
                sum++;                         // akkor a sum vált értékét növeli eggyel
            }
        }
        return sum;                            // visszatér a sum vált értékével
    }

    @Override
    public String toString() {                  // toString() metódus
        return toDoList.toString();             // ami szövegesen adja vissza az 1. listát
    }


}
