package advanced;

import java.util.Collection;
import java.util.TreeSet;

public class SayNoToDuplication<T> {
    public Collection<T> getCollectionWithoutDuplication(Collection<T> collection) {
        for (int i = 0; i < collection.toArray().length-1; i++) {
            for (int j = 1; j < collection.toArray().length-1; j++) {
                if (collection.toArray()[i]==collection.toArray()[j]){
                    collection.remove(collection.toArray()[i]);
                }
            }
        }
        return collection;
    }
    public Collection<T> getCcollectionWithoutDuplication(Collection<T> collection) {
        return new TreeSet(collection);
    }
}
