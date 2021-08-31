package search;

public enum MenuRequest {
    INVALID_REQUEST(-1, null),
    FIND_A_PERSON(1, "Find a person"),
    PRINT_ALL_PEOPLE(2, "Print all people"),
    EXIT(0, "Exit");

    private final int identifier;
    private final String label;

    MenuRequest(int identifier, String label) {
        this.identifier = identifier;
        this.label = label;
    }

    public static String getMenu() {
        StringBuilder menu = new StringBuilder();

        for (MenuRequest r: MenuRequest.values()) {
            if (r != INVALID_REQUEST) {
                menu.append(String.format("%d. %s%n", r.identifier, r.label));
            }
        }

        return menu.toString();
    }

    public static MenuRequest getRequest(int identifier) {
        for (MenuRequest r: MenuRequest.values()) {
            if (r.identifier == identifier) {
                return r;
            }
        }

        return INVALID_REQUEST;
    }
}