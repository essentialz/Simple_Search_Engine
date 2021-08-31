package search;

import java.util.Map;
import java.util.Set;

public interface SearchMethod {
    Set<Integer> search(Map<String, Set<Integer>> invertedKeyMap, String query);
}
