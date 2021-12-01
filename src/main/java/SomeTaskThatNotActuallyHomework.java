import java.util.Arrays;

public class SomeTaskThatNotActuallyHomework {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 1, 3, 5};
        bubbleSort(array);
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
             int x = array[i];
                array[i] = array[i+1];
                array[i+1] = x;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
