package search;

public class Person {
    private final String firstName;
    private final String lastName;
    private final String email;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public static Person of(String[] data) {
        return data.length == 1 ? new Person(data[0], "", "")
                : data.length == 2 ? new Person(data[0], data[1], "")
                : new Person(data[0], data[1], data[2]);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", firstName, lastName, email).trim();
    }
}
