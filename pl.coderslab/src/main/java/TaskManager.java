import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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
            switch (option) {
                case "exit" -> {
                    exit(tasks, FILENAME);
                    System.exit(0);
                }
                case "add" -> {
                    addTask(tasks);
                }
                case "list" -> {
                    listTask(tasks);
                }
                case "remove" -> tasks = removeTask(tasks);
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
            return tasks;
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

    private static List addTask(List tasks) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please add task description:");
        String s1 = sc.nextLine();
        System.out.println("Please add task due date:");
        String s2 = sc.nextLine();
        System.out.println("Is your task important: true/false");
        while (!sc.hasNextBoolean()) {
            sc.nextLine();
            System.out.println("Please true/false"); }
        String s3 = sc.nextLine();
        String newLine = s1 + ", " + s2 + ", " + s3;
        tasks.add(newLine);
        return tasks;
    }

    private static void exit(List tasks,String file) {
        Path p = Paths.get(file);
        try {
            Files.write(p,tasks);
        } catch (IOException e) {System.out.println(e.getMessage());
        }
        System.out.println(ConsoleColors.RED);
        System.out.print("Bye, bye.");
        System.out.println(ConsoleColors.RESET);
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
