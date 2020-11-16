package Intromethods.todo;

import java.util.Arrays;

public class ToDoListMain {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();

        toDoList.addToDo("- Learn and practise");
        toDoList.addToDo("- Learning with my son");
        toDoList.addToDo("- Change summer tires");
        toDoList.addToDo("- Phonecall the lawyer");

        System.out.println(toDoList);

        toDoList.finishToDos("- Change summer tires");

        System.out.println(toDoList);
        System.out.println(toDoList.numberOfFinishedTodos());

        toDoList.finishAllTodos(Arrays.asList("- Learning with my son", "- Phonecall the lawyer"));

        System.out.println(toDoList);
        System.out.println(toDoList.numberOfFinishedTodos());
    }
}
