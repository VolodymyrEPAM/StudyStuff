package advanced;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task4 {
    public static void main(String[] args) {
        String[] orderIds = new String[]{"1", "1", "2", "2", "4", "4","3", "3", "5", "5"};
        Set<String> hashSet = new HashSet<>(Arrays.asList(orderIds));
        Set<String> treeSet = new TreeSet<>(Arrays.asList(orderIds));
        System.out.println(hashSet);
        System.out.println(treeSet);
    }
}
