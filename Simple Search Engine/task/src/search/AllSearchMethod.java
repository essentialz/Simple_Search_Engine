package search;

import java.util.*;

public class AllSearchMethod implements SearchMethod {

    @Override
    public Set<Integer> search(Map<String, Set<Integer>> invertedKeyMap, String query) {
        Set<Integer> results = new HashSet<>();
        String[] words = query.toLowerCase().split(" +");

        for (String word: words) {
            Optional<Set<Integer>> value = Optional.ofNullable(invertedKeyMap.get(word));
            value.ifPresent(v -> {
                if (results.isEmpty()) {
                    results.addAll(value.get());
                } else {
                    results.retainAll(value.get());
                }
            });
        }

        return results;
    }
}
