package todolist;

        import java.io.*;
        import java.util.ArrayList;

        import tasksmanagement.*;

/**
 * Todoapp class has the main method to execute from.
 * It displays the welcome message and main menu of the application
 */

public class Todoapp {

    public static void main(String[] args) throws IOException {
        TaskOperations todo = new TaskOperations();
        ArrayList<Task> taskList = new ArrayList<>();
        Todoapp menu = new Todoapp();
        System.out.println("***** welcome to TODO Application *****");
        todo.TaskMenu();
    }
}
