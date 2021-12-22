package advanced;

import java.util.*;

public class ArraysToMap<K, V> {

    public Map convertArraysToMap(K[] keys, V[] values) {
        Map<K, V> map = new HashMap<>();
        List<V> valuesIfKeysAmountMore = new ArrayList(Arrays.asList(values));
        int size = keys.length - values.length;
        for (int i = 0; i < size; i++) {
            valuesIfKeysAmountMore.add(null);
        }
        try {
            if (keys.length > values.length) {
                for (int i = 0; i < keys.length; i++) {
                    for (int j = 0; j < valuesIfKeysAmountMore.toArray().length; j++) {
                        map.put(keys[i], valuesIfKeysAmountMore.get(j));
                        i++;
                    }
                }
                throw new Exception("Value is not enough for map!!!");
            } else if (keys.length < values.length) {
                for (int i = 0; i < values.length; i++) {
                    for (int j = 0; j < keys.length; j++) {
                        map.put(keys[i], values[j]);
                        i++;
                    }
                }
                throw new Exception("Key is not enough for map!!!");
            } else {
                for (int i = 0; i < values.length; i++) {
                    for (int j = 0; j < keys.length; j++) {
                        map.put(keys[i], values[j]);
                        i++;
                    }
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return map;
    }
}
