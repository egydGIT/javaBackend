package debug;

import java.util.ArrayList;
import java.util.List;

public class Company {
    // Employee employee = new Employee();

    private List<Employee> employees;                       // employees nevű lista deklaráció

    public Company(List<Employee> employees) {              // Konstruktor, paraméterben kapott listát
        this.employees = employees;                         // értékül adja a fent deklarált listának

    }

    public void addEmployee(Employee employee) {            // addE metódus, ami a param-ben átadott nevet
        employees.add(employee);                            // add met-sal hozzáadja a listához
    }

    public Employee findEmployeeByName(String name) {          // Metódus, ami adott nevet keres a listában
        for (Employee employee : employees) {              // For-each ciklus, deklarál egy Emloyee tipusú változót,
                                                                // ami végigiterál a lista minden elemén
            if (employee.getName().equals(name)) {         // For-e c változójára meghívom getName met-t Visszaad: nevet
                                                                // majd ezt a nevet összehasonlítom az equals met-sal
                                                                // a findEBN met paraméterében megadott névvel.
                return employee;                            // Visszatér a f-e c változója. Visszat.érték: true, false
            }
        }
        return null;                                        // ??
    }

    public List<String> listEmployeeNames() {                       // Metódus, ami kiírja a listában lévő neveket
        List<String> names = new ArrayList<>();             // 2. lista deklaráció, amibe elmentem az első lista neveit
        for (Employee employee : employees) {               // for-e ciklus, ami végig lépked az emloyye listán
            names.add(employee.getName());                  // 2. listához add metódussal hozzáadom
                                                            // employee vált. getName met-sal lekért aktuális értékét
        }
        return names;                                       // miután lezajlott a f-e ciklus, téjen vissza a 2. listával
    }
}
