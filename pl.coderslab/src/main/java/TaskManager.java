import org.apache.commons.lang3.ArrayUtils;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class TaskManager {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String FILENAME = "tasks.csv";
        List tasks = readFileToArray(FILENAME);

        while (true){
            menuPrint();
            String option = sc.nextLine();
            switch (option){
                case "exit":
                    exit();

                case "add":
                    addTask();

                case "list":
                    listTask(tasks);
                    break;

                case "remove":
                    tasks = removeTask(tasks);
                    break;
            }
        }
    }

    private static List removeTask(List tasks) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select select number to remove:");
        while (!sc.hasNextInt()){
            sc.nextLine();
            System.out.println("Select select number to remove:");
            }
        int x = sc.nextInt();
        if (x > tasks.size()-1) {
            System.out.println("Sorry, there is no such task.");
            removeTask(tasks);
        } else {
            System.out.println("Value successfully deleted.");
            tasks.remove(x);
        }
        return tasks;
    }

    private static void listTask(List tasks) {
        if (tasks.isEmpty()){
            System.out.println("Sorry, there are no tasks.\n");
        }
        for (int i = 0; i < tasks.size(); i++) {
            String str = tasks.get(i).toString().replace(","," ");
            System.out.println(i + " : " + str);
        }
    }

    private static void addTask() {
    }

    private static void exit() {
    }

    private static List<String> readFileToArray(String file) {
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
