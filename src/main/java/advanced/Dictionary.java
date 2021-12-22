package advanced;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    public static Map<Character, Integer> getDictionary(String string) {
        Map<Character, Integer> characterIntegerMap = new HashMap();
        char[] chars = string.toCharArray();
        for (char eachChar : chars) {
            if (characterIntegerMap.containsKey(eachChar)) {
                characterIntegerMap.put(eachChar, characterIntegerMap.get(eachChar) + 1);
            } else {
                characterIntegerMap.put(eachChar, 1);
            }
        }
        return characterIntegerMap;
    }
}
