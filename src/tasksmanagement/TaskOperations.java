package tasksmanagement;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import static tasksmanagement.FileOperations.writeToFile;


public class TaskOperations extends Task {

    FileOperations file = new FileOperations();
    private ArrayList<Task> taskList = (ArrayList<Task>) file.readFromFile("Tasklist.txt");
    Scanner s = new Scanner(System.in);

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
        System.out.println("Title:" +title);
        System.out.println("Duedate:" +duedate);
        System.out.println("Project:" +project);
        System.out.println("Status:" +status);
        String confirm = s.next();
        if(confirm.toUpperCase().equals("Y")) {
            Task task = new Task(title, duedate, project, status);
            taskList =  addTask(task,taskList);
        }
        else
        {
            TaskMenu();
        }



    }

    public ArrayList<Task> addTask(Task task,ArrayList<Task> taskList) throws IOException {

            taskList.add(task);
            System.out.println("Task has been added successfully");
            return taskList;
        }


   public void getInputToEditTask() throws IOException {
        getTasks();
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the task index you want to edit");

        int index = s.nextInt();
        while(index>(taskList.size()-1)||(index<0))
        {
            System.out.println("Please enter valid task index to edit");
            index = s.nextInt();
        }
        System.out.println("Please enter the details you wanted to edit in the above task ");
        System.out.println("such as \"title\" or \"duedate\" or \"project\" or \"status\" ");
        String editdetails = s.next();
       // Task t = taskList.get(index);
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

            //   t.status = newstatus;
               break;
           default :
               System.out.println("invalid input");
               TaskMenu();

       }
        String newdetails = s.next();
        taskList = editTask(index,editdetails,newdetails,taskList);

     }
    public ArrayList<Task> editTask(int index,String editdetails,String newdetails,ArrayList<Task> taskList) throws IOException {

            Task t = taskList.get(index);
            switch (editdetails) {
                case "title":
                    t.title = newdetails;
                    break;

                case "duedate":
                    LocalDate newDuedate = convertStringToDate(newdetails);
                    t.duedate = newDuedate;
                    break;

                case "project":
                    t.project = newdetails;
                    break;

                case "status":
                    t.status = newdetails;
                    break;

            }

            System.out.println("Task has been edited successfully");
            return taskList;


    }
public void getIndexToRemoveTask() throws IOException {
    getTasks();
    Scanner s = new Scanner(System.in);
    System.out.println("please enter the index of the task you want to remove");

    int index = s.nextInt();
    taskList = removeTask(index,taskList);

}

    public ArrayList<Task> removeTask(int index,ArrayList<Task> taskList) throws IOException {


        while((index>(taskList.size()-1))||(index<0))
        {
            System.out.println("Please enter valid task index to remove");
            index = s.nextInt();
        }

        taskList.remove(index);
        System.out.println("Requested task is successfully deleted from the tasklist");
       return taskList;

    }


    public void getTasks() throws IOException {

        System.out.println("taskname   duedate   project   status");

        for(int i =0;i<taskList.size();i++)
        {
            System.out.println(i+ ":" +taskList.get(i).title +"   "+taskList.get(i).duedate+
                    "   "+taskList.get(i).project+ "   "+taskList.get(i).status);

        }
          }

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





    public void saveAndQuit()
    {

        writeToFile("Tasklist.txt", taskList);
        System.out.println("Tasks details have been succesfully saved into the external file(Tasklist.txt)");

    }

   // pubic void showTasks()


    public  void TaskMenu() throws IOException {

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
            case 5 :
                saveAndQuit();
                 break;
            default: System.out.println("INVALID INPUT");
                saveAndQuit();
        }

    }

    public LocalDate convertStringToDate(String dateString)
    {
        LocalDate date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while(true)
        {
            try{
                date = LocalDate.parse(dateString, formatter);
                //System.out.println(date);
                return date;
            }
            catch ( Exception e ){
                System.out.println("Invalid date. Please try again. ");
                 dateString = s.nextLine();
            }
        }
    }



}
