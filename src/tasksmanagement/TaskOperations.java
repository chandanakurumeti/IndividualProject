package tasksmanagement;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import static tasksmanagement.FileOperations.writeToFile;

/**
 * This Class TaskOperations extends the Task class and has all the methods related to tasks.
 **/

public class TaskOperations extends Task {

    FileOperations file = new FileOperations();
    private ArrayList<Task> taskList = (ArrayList<Task>) file.readFromFile("Tasklist.txt");
    Scanner s = new Scanner(System.in);

    /**
     * getTaskDataToAdd() method gets the task data from the user which has to be added.
     *
     * @throws IOException
     */

    public void getTaskDataToAdd() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter title of the task you wanted to add");
        String title = s.nextLine();
        System.out.println("Please enter duedate of the task you wanted to add");
        String date = s.nextLine();
        LocalDate duedate = convertStringToDate(date);
        System.out.println("Please enter project of the task you wanted to add");
        String project = s.nextLine();
        System.out.println("Please enter status of the task you wanted to add");
        String status = s.nextLine();
        System.out.println("Please confirm the below task details");
        System.out.println("Enter \"Y\" if you want to add the task into the file,");
        System.out.println("Enter any character to go back to main menu");
        System.out.println("Title:" + title);
        System.out.println("Duedate:" + duedate);
        System.out.println("Project:" + project);
        System.out.println("Status:" + status);
        String confirm = s.next();
        if (confirm.toUpperCase().equals("Y")) {
            Task task = new Task(title, duedate, project, status);
            taskList = addTask(task, taskList);
        } else {
            TaskMenu();
        }

    }

    /**
     * addTask() method adds the task into the arraylist
     *
     * @param task
     * @param taskList
     * @return ArrayList<Task> taskList
     * @throws IOException
     */

    public ArrayList<Task> addTask(Task task, ArrayList<Task> taskList) throws IOException {

        taskList.add(task);      // task is adding into the taskList
        System.out.println("Task has been added successfully");
        return taskList;
    }

    /**
     * getInputToEditTask() method get the input data required to edit the task from the user
     *
     * @throws IOException
     */

    public void getInputToEditTask() throws IOException {
        getTasks();
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the task index you want to edit");

        int index = s.nextInt();
        while (index > (taskList.size() - 1) || (index < 0))      // checking if the index provided is valid or not
        {
            System.out.println("Please enter valid task index to edit");
            index = s.nextInt();
        }
        System.out.println("Please enter the details you wanted to edit in the above task ");
        System.out.println("such as \"title\" or \"duedate\" or \"project\" or \"status\" ");
        String editdetails = s.next();

        switch (editdetails) {
            case "title":
                System.out.println("enter the new title for your task:");
                break;
            case "duedate":
                System.out.println("enter the new duedate for your task:");
                break;
            case "project":
                System.out.println("enter the new project for your task:");
                break;
            case "status":
                System.out.println("enter the new status for your task:");
                break;
            default:
                System.out.println("invalid input");
                TaskMenu();

        }
        String newdetails = s.next();
        taskList = editTask(index, editdetails, newdetails, taskList);

    }

    /**
     * editTask() method edits the task details as requested by the user
     *
     * @param index
     * @param editdetails
     * @param newdetails
     * @param taskList
     * @return ArrayList<Task> taskLight
     * @throws IOException
     */
    public ArrayList<Task> editTask(int index, String editdetails, String newdetails, ArrayList<Task> taskList) throws IOException {

        Task t = taskList.get(index);
        switch (editdetails) {
            case "title":
                t.title = newdetails;         //editing the value of title from old to new title as user requested
                break;

            case "duedate":
                LocalDate newDuedate = convertStringToDate(newdetails);
                t.duedate = newDuedate;       //editing the value of duedate from old to new duedate as user requested
                break;

            case "project":
                t.project = newdetails;       //editing the value of project from old to new project as user requested
                break;

            case "status":
                t.status = newdetails;        //editing the value of status from old to new status as user requested
                break;

        }

        System.out.println("Task has been edited successfully");
        return taskList;
    }

    /**
     * getIndexToRemoveTask method takes the index of the task which needs to be removed from the user
     *
     * @throws IOException
     */

    public void getIndexToRemoveTask() throws IOException {
        getTasks();
        Scanner s = new Scanner(System.in);
        System.out.println("please enter the index of the task you want to remove");
        int index = s.nextInt();
        taskList = removeTask(index, taskList);

    }

    /**
     * removeTask() method removes the specific task from the tasklist based on the index provided as a parameter
     *
     * @param index
     * @param taskList
     * @return
     * @throws IOException
     */

    public ArrayList<Task> removeTask(int index, ArrayList<Task> taskList) throws IOException {

        while ((index > (taskList.size() - 1)) || (index < 0))     //checking the index provided by the user is valid or not.
        {
            System.out.println("Please enter valid task index to remove");
            index = s.nextInt();
        }

        taskList.remove(index);
        System.out.println("Requested task is successfully deleted from the tasklist");
        return taskList;

    }

    /**
     * getTasks() method displays all the tasks present in the array list.
     * @throws IOException
     */

    public void getTasks() throws IOException {

        System.out.println("taskname   duedate   project   status");

        for (int i = 0; i < taskList.size(); i++) {
            System.out.println(i + ":" + taskList.get(i).title + "   " + taskList.get(i).duedate +
                    "   " + taskList.get(i).project + "   " + taskList.get(i).status);

        }
    }

    /**
     * showTasks() method shows all the tasks in the arraylist and asks the user whether he wants to continue or not
     *
     * @throws IOException
     */

    public void showTasks() throws IOException {
        getTasks();
        System.out.println("Please enter yes if you want to do some other operations with the tasks");
        String newoperation = s.next();
        if (newoperation.toLowerCase().equals("yes")) {
            TaskMenu();
        } else {
            saveAndQuit();
        }
    }

    /**
     * saveAndQuit() method saves the tasks in arraylist into the file and quits from the application
     */

    public void saveAndQuit() {
        writeToFile("Tasklist.txt", taskList);     //writing the arraylist data into the file
        System.out.println("Tasks details have been succesfully saved into the external file(Tasklist.txt)");
    }


    /**
     * TaskMenu() method lets the user select the operation he wants to do with the task
     *
     * @throws IOException
     */

    public void TaskMenu() throws IOException {

        System.out.println("Main Menu");
        System.out.println("1.Add the task");
        System.out.println("2.Edit the existing task");
        System.out.println("3.Remove the task");
        System.out.println("4.See the Tasks");
        System.out.println("5.Save and Quit");
        System.out.println();
        System.out.println("Please select your choice");
        int input = s.nextInt();

        switch (input) {
            case 1:
                try {
                    getTaskDataToAdd();
                    showTasks();
                } catch (IOException e) {
                    System.out.println(e);
                }

                break;

            case 2:
                getInputToEditTask();
                showTasks();
                break;

            case 3:
                getIndexToRemoveTask();
                showTasks();
                break;

            case 4:
                showTasks();

                break;
            case 5:
                saveAndQuit();
                break;
            default:
                System.out.println("INVALID INPUT");
                saveAndQuit();
        }

    }

    /**
     * convertStringToDate() method converts date in string into localdate format
     *
     * @param dateString
     * @return
     */

    public LocalDate convertStringToDate(String dateString) {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            try {
                date = LocalDate.parse(dateString, formatter);
                return date;
            } catch (Exception e) {
                System.out.println("Invalid date. Please try again. ");
                dateString = s.nextLine();
            }
        }
    }


}
