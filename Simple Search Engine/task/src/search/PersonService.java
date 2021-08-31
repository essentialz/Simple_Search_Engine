package search;

import java.util.*;

public class PersonService {
    private final List<Person> personRepo;
    private final Map<String, Set<Integer>> invertedKeyMap;

    public PersonService(String file) {
        this.personRepo = new ArrayList<>();
        this.invertedKeyMap = new HashMap<>();

        try (Scanner fileScanner = new Scanner(file)) {
            for (int i = 0; fileScanner.hasNextLine(); i++) {
                save(fileScanner.nextLine(), i);
            }
        }
    }

    public List<Person> getPersonRepo() {
        return personRepo;
    }

    private void save(String line, int index) {
        String[] words = line.split(" +");
        personRepo.add(Person.of(words));

        for (String word: words) {
            Optional<Set<Integer>> value = Optional.ofNullable(invertedKeyMap.get(word.toLowerCase()));
            value.ifPresentOrElse(v -> v.add(index),
                    () -> invertedKeyMap.put(word.toLowerCase(), new HashSet<>(Set.of(index))));
        }
    }

    public Set<Integer> findAll(String query, SearchMethod method) {
        Searcher searcher = new Searcher(invertedKeyMap, method);

        return searcher.search(query.toLowerCase());
    }
}
