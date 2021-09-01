import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] first = scanner.nextLine().toLowerCase().toCharArray();
        Arrays.sort(first);

        char[] second = scanner.nextLine().toLowerCase().toCharArray();
        Arrays.sort(second);


        System.out.println(Arrays.equals(first, second) ? "yes" : "no");
    }
}