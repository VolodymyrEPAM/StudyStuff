import java.util.Arrays;

public class SomeTaskThatNotActuallyHomework {
    public static void main(String[] args) {
        int[] array = new int[]{5,57,1,2,34,3,5,8,76,32};
        bbubbleSort(array);
    }

    private static void bbubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i]>array[j]){
                    int x = array[j];
                    array[j]=array[i];
                    array[i]=x;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
