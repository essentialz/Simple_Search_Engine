package search;

import java.util.List;
import java.util.Set;

public enum Display {
    SELECT_MATCHING_STRATEGY("Select a matching strategy: ALL, ANY, NONE"),
    ENTER_NAME_OR_EMAIL("Enter a name or email to search all suitable people."),
    NO_MATCHES_FOUND("No matching people found."),
    INCORRECT_OPTION("Incorrect option! Try again."),
    INCORRECT_STRATEGY("Incorrect strategy! Try again."),
    MENU_HEADER("=== Menu ==="),
    LIST_OF_PEOPLE_HEADER("=== List of people ==="),
    PEOPLE_FOUND("%d persons found:%n"),
    BYE("Bye!"),
    SPACER("");

    private final String prompt;

    Display(String prompt) {
        this.prompt = prompt;
    }

    public static void display(Display item) {
        System.out.println(item.prompt);
    }

    public static void displayPeople(List<Person> personRepo, Set<Integer> indexes) {
        System.out.printf(PEOPLE_FOUND.prompt, indexes.size());
        indexes.forEach(i -> System.out.println(personRepo.get(i)));
    }

    public static void displayAllPeople(List<Person> personRepo) {
        display(LIST_OF_PEOPLE_HEADER);
        personRepo.forEach(System.out::println);
    }

    public static void displayMenu() {
        display(MENU_HEADER);
        System.out.print(MenuRequest.getMenu());
    }
}
