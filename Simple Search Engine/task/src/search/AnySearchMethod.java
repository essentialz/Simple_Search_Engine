package search;

import java.util.*;

public class AnySearchMethod implements SearchMethod {

    @Override
    public Set<Integer> search(Map<String, Set<Integer>> invertedKeyMap, String query) {
        Set<Integer> results = new HashSet<>();
        String[] words = query.split(" +");

        for (String word: words) {
            Optional<Set<Integer>> value = Optional.ofNullable(invertedKeyMap.get(word));
            value.ifPresent(results::addAll);
        }

        return results;
    }
}