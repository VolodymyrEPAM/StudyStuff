package advanced;


import java.util.*;

import static advanced.Dictionary.getDictionary;

public class HomeTask {
    public static void main(String[] args) {
        SayNoToDuplication noToDuplication = new SayNoToDuplication();
        MapSwapper mapSwapper = new MapSwapper();
        String someString = "ABOBUS";
        System.out.println("Task1: " + getDictionary(someString));
        System.out.println(" ");

        List<Integer> list = new ArrayList();
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(6);
        System.out.println("Task2(before): " + list);
        System.out.println("Task2(after): " + noToDuplication.getCollectionWithoutDuplication(list));
        System.out.println(" ");

        Map<Integer, String> states = new HashMap();
        states.put(1, "Germany");
        states.put(2, "Spain");
        states.put(4, "France");
        states.put(3, "Italy");
        System.out.println("Task3(before): " + states);
        System.out.println("Task3(after): " + mapSwapper.getSwappedMap(states));
        System.out.println(" ");

        ArraysToMap arraysToMap = new ArraysToMap();
        String[] words = new String[]{"a", "b", "c", "d", "e"};
        Integer[] numbers = new Integer[]{1, 2, 3, 4, 5};
        System.out.println("Task5: " + arraysToMap.convertArraysToMap(numbers, words));
    }
}
