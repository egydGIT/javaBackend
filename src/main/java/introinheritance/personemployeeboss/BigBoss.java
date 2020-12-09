package introinheritance.personemployeeboss;

public class BigBoss extends Boss {
    private double bonus;

    public BigBoss(String name, String address, double salary, int numberOfEmployees, double bonus) {
        super(name, address, salary, numberOfEmployees);
        this.bonus = bonus;
    }

    public int getNumberOfEmployees() {
        return super.getNumberOfEmployees();
    }

    public double getBonus() {
        return bonus;
    }

    public double getSalaryBigBoss() {                  // Salary 1.
        return super.getSalaryBoss() + bonus ;
    }

    public double getSalary() {                         // Salary 2.
        return super.getSalary() + bonus;
    }


    public static void main(String[] args) {
        // Employee
        Employee employee1 = new Employee("Márk", "Budapest", 240_000);
        System.out.println("Emploxee: " + employee1.getSalary());
        System.out.println("Emploxee: " + employee1.raiseSalary(20));

        // Boss
        Employee employee2 = new Boss("Ferenc", "Budapest", 240_000, 7);
        System.out.println("employee2 Boss: " + employee2.getSalary());         // Érdekes, ez a Bossban dekl. getSalary()
                                                                                // de getSararyBoss() nincs...
        Boss boss = new Boss("Ferenc", "Budapest", 240_000, 7);
        System.out.println("boss Boss: " + boss.getSalary());
        System.out.println("boss Boss: " + boss.getSalaryBoss());

        // BigBoss
        Employee employee3 = new BigBoss("George", "London", 240_000, 28, 200_000);
        System.out.println("employee3 BigBoss: " + employee3.getSalary());

        BigBoss bigBoss = new BigBoss("George", "London", 240_000, 28, 200_000);
        System.out.println("bigBoss BigBoss: " + bigBoss.getSalary());
        System.out.println("bigBoss BigBoss: " + bigBoss.getSalaryBigBoss());

    }
}
