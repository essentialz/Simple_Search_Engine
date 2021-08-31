package search;

import java.util.*;

public class NoneSearchMethod implements SearchMethod {

    @Override
    public Set<Integer> search(Map<String, Set<Integer>> invertedKeyMap, String query) {
        Set<Integer> result = new HashSet<>();
        String[] words = query.split(" +");

        invertedKeyMap.values().forEach(result::addAll);

        for (String word: words) {
            Optional<Set<Integer>> value = Optional.ofNullable(invertedKeyMap.get(word));
            value.ifPresent(result::removeAll);
        }

        return result;
    }
}