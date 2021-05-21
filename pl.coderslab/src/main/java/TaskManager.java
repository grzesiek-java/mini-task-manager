import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TaskManager {

    public static void main(String[] args) {
        final String FILENAME = "tasks.csv";
        menuPrint();
        readFileToArray(FILENAME);


    }

    private static List readFileToArray(String file) {
        List<String> tasks = new ArrayList<>();
        Path p = Paths.get(file);

        try {
            tasks = Files.readAllLines(p);
        } catch (IOException e) { System.out.println(e.getMessage()); }
        return tasks;
        }

    private static void menuPrint() {
        System.out.println(ConsoleColors.BLUE);
        System.out.print("Please select an option: ");
        System.out.println(ConsoleColors.RESET);
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("exit");
    }
}
