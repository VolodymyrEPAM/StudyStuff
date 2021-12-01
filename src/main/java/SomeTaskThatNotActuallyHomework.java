import java.util.Arrays;

public class SomeTaskThatNotActuallyHomework {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 1, 3, 5};
        bubbleSort(array);
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                int x = array[i + 1];
                array[i + 1] = array[i];
                array[i] = x;
            }
        }
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] > array[j + 1]) {
                int y = array[j + 1];
                array[j + 1] = array[j];
                array[j] = y;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
