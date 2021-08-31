package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2 || !"--data".equals(args[0])) {
            throw new RuntimeException("Invalid Command Line argument!");
        }

        try {
            String file = Files.readString(Paths.get(args[1]));
            Program program = new Program(file);
            program.run();
        } catch (InvalidPathException | IOException e) {
            System.out.println("Invalid Path!");
        }
    }
}
