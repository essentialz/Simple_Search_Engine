package search;

import java.util.*;

public class Searcher {
    private final Map<String, Set<Integer>> invertedKeyMap;
    private final SearchMethod method;

    public Searcher(Map<String, Set<Integer>> invertedKeyMap, SearchMethod method) {
        this.invertedKeyMap = invertedKeyMap;
        this.method = method;
    }

    public Set<Integer> search(String query) {
        return method.search(invertedKeyMap, query);
    }
}
