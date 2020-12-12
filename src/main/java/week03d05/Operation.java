package week03d05;

import java.util.Scanner;

public class Operation {

    /*
    2020-11-13 (week03d05)
        Írj egy Operation osztályt, mely konstruktorban kap egy összeadást, pl. 68+12!
        A getResult() metódus visszaadja a művelet eredményét.
        Egy belső leftOperand és rightOperand attribútumba dolgozz!
     */

    private int leftOperand;
    private int rightOperand;

    public Operation(int leftOperand, int rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public int getResult() {
        return leftOperand + rightOperand;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adj meg két számot! ");
        System.out.println("1. szám:  ");
        int leftOperand = scanner.nextInt();
        // System.out.println();

        System.out.println("2. szám:  ");
        int rightOperand = scanner.nextInt();

        // System.out.println();
        Operation operation = new Operation(leftOperand, rightOperand);
        System.out.println("Összeg = " + operation.getResult());
    }

}
