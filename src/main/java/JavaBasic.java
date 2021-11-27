public class JavaBasic {
    public static void main(String[] args) {

        int task1 = 74 + 36;
        System.out.println("result of first task: " + task1);

        int task2a = -5 + 8 * 6;
        int task2b = (55 + 9) % 9;
        int task2c = 20 + -3 * 5 / 8;
        int task2d = 5 + 15 / 3 * 2 - 8 % 3;
        System.out.println("result of second task: " + task2a + " , " + task2b + " , " + task2c + " , " + task2d + ";");

        int task3FirstNumber = 125;
        int task3SecondNumber = 24;
        System.out.println("sum: " + sum(task3FirstNumber, task3SecondNumber));
        System.out.println("subtract: " + subtract(task3FirstNumber, task3SecondNumber));
        System.out.println("divide: " + divide(task3FirstNumber, task3SecondNumber));
        System.out.println("multiply: " + multiply(task3FirstNumber, task3SecondNumber));
        System.out.println("remainder of two numbers: " + remainderOfTwoNumbers(task3FirstNumber, task3SecondNumber));

        int[] task4 = {5, 6, 7, 12, -5, 32, 43};
        System.out.println("sum of all numbers in array: " + sumOfAllNumbersInArray(task4));
        System.out.println("another sum of all numbers in array: " + anotherSumOfAllNumbersInArray(task4));

        int[] task5 = {5, 6, 7, 12, -5, 32, 43, 6, 12};
        showDuplicateNumbersInArray(task5);
    }

    public static int sum(int a, int b) {
        int c = a + b;
        return c;
    }

    public static int subtract(int a, int b) {
        int c = a - b;
        return c;
    }

    public static int multiply(int a, int b) {
        int c = a * b;
        return c;
    }

    public static int divide(int a, int b) {
        int c = a / b;
        return c;
    }

    public static int remainderOfTwoNumbers(int a, int b) {
        int c = a % b;
        return c;
    }

    public static int anotherSumOfAllNumbersInArray(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i];
        }
        return result;
    }

    public static int sumOfAllNumbersInArray(int[] array) {
        int result = 0;
        int i = 0;
        while (i < array.length) {
            result += array[i];
            i++;
        }
        return result;
    }

    public static void showDuplicateNumbersInArray(int[] array) {
        int x = 0;
        int y = 0;
        int result1 = 0;
        while (x<array.length){
            x++;
            while (y<array.length){
                if (array[x]==array[y]){
                    result1 = array[y];
                }
                y++;
            }
        }
        int result = 0;
        int[] secondArray = array;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++){
                if (array[i]==array[j]){
                    result = array[j];
                }
            }
        }
        System.out.println(result1);
        System.out.println(result);
    }
}
