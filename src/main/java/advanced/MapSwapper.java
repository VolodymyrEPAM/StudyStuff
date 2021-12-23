package advanced;

import java.util.HashMap;
import java.util.Map;

public class MapSwapper {
    public <K,V> HashMap<V,K> getSwappedMap(Map<K,V> map) {
        HashMap<V,K> reverse = new HashMap();
        for(Map.Entry<K,V> entry : map.entrySet())
            reverse.put(entry.getValue(), entry.getKey());
        return reverse;
    }
}
