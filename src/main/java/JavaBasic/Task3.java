package JavaBasic;

import static Utils.CalculationUtils.*;

public class Task3 {
    public static void main(String[] args) {
        int task3FirstNumber = 125;
        int task3SecondNumber = 24;
        System.out.println("sum: " + sum(task3FirstNumber, task3SecondNumber));
        System.out.println("subtract: " + subtract(task3FirstNumber, task3SecondNumber));
        System.out.println("divide: " + divide(task3FirstNumber, task3SecondNumber));
        System.out.println("multiply: " + multiply(task3FirstNumber, task3SecondNumber));
        System.out.println("remainder of two numbers: " + remainderOfTwoNumbers(task3FirstNumber, task3SecondNumber));
    }
}
