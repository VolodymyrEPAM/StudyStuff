package JavaBasic;

public class Task5 {
    public static void main(String[] args) {
        int[] task5 = new int[]{5, 6, 7, 12, -5, 32, 43, 6, 12};
        showDuplicateNumbersInArray(task5);
    }

    public static void showDuplicateNumbersInArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    System.out.println(array[i]);
                }
            }
        }
    }
}
