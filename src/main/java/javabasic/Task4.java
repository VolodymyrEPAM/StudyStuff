package javabasic;

public class Task4 {
    public static void main(String[] args) {
        int[] task4 = new int[]{5, 6, 7, 12, -5, 32, 43};
        System.out.println("sum of all numbers in array: " + sumOfAllNumbersInArray(task4));
    }

    public static int sumOfAllNumbersInArray(int[] array) {
        int result = 0;
        for (int x : array) {
            result += x;
        }
        return result;
    }

}
