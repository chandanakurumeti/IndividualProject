import java.util.ArrayList;
import java.util.Scanner;


public class Todoapp {

    private ArrayList<Task> taskList = new ArrayList<>();

    public static void main(String[] args)
    {
        Todoapp vacation = new Todoapp();
        System.out.println("welcome to TODO Application");
        System.out.println("Please select what you want to do");
        System.out.println("1.Add the task");
        System.out.println("2.edit the existing task");
        System.out.println("3.remove the task");
        System.out.println();
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();

        switch(input) {
            case 1 :
                vacation.addTask();
                break;

            case 2 :
                vacation.editTask();
                break;

            case 3 :
                vacation.removeTask();
                break;

            default : // Optional
                // Statements
        }



    }

    public void addTask()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter title of the task you wanted to add");
        String title = s.nextLine();
        System.out.println("Please enter duedate of the task you wanted to add");
        String duedate = s.nextLine();
        System.out.println("Please enter project of the task you wanted to add");
        String project = s.nextLine();
        System.out.println("Please enter status of the task you wanted to add");
        String status = s.nextLine();

        System.out.println("Please confirm the below details of the task ,enter Y/N (case sensitive)");
        System.out.println("Title:" +title);
        System.out.println("duedate:" +duedate);
        System.out.println("project:" +project);
        System.out.println("status:" +status);

        String confirm = s.next();
        if(confirm.equals("Y"))
        {
            Task task = new Task(title,duedate,project,status);
            taskList.add(task);
            System.out.println("Task has been added successfully..Thank you");
            System.out.println("Please enter yes if you want to add more tasks");
            String addagain = s.next();
            if(addagain.equals("yes")) {
                addTask();
            } else {
                editTask();
            }
        }
        else
        {
            System.out.println("please add the correct task details to add ");
           addTask();
        }



    }

    public void editTask()
    {
        showtasks();
        System.out.println("Please enter the task index you want to edit");
        Scanner s = new Scanner(System.in);
        int index = s.nextInt();
        System.out.println("Please enter the details you wanted to edit in the above task");
        String editdetails = s.next();
        Task t = taskList.get(index);
        switch(editdetails) {
            case "title" :
                System.out.println("enter the new title for your task:");
                String newtitle = s.next();
                t.taskname =newtitle;
                break;

            case "duedate" :
                System.out.println("enter the new duedate for your task:");
                String newduedate = s.next();
                t.duedate =newduedate;

                break;

            case "project" :
                System.out.println("enter the new project for your task:");
                String newproject = s.next();
                t.duedate =newproject;
                break;

            case "status" :
                System.out.println("enter the new status for your task:");
                String newstatus = s.next();
                t.duedate =newstatus;
                break;

        }
        System.out.println("Task details has been edited successfully as below");
        System.out.println(index+ ":" +taskList.get(index).taskname+"  "+taskList.get(index).duedate+
                "  "+taskList.get(index).project+ "  "+taskList.get(index).status);
        System.out.println("you want to edit any other details of same or other tasks");
        String editagain = s.next();
        System.out.println(editagain);
        if(editagain.equals("yes"))
        {
            editTask();

        }
        else
        {
            removeTask();
            return;

        }


    }

    public void removeTask()
    {

        showtasks();
        System.out.println("please enter the index of the task you want to remove");
        Scanner s = new Scanner(System.in);
        int index = s.nextInt();
        taskList.remove(index);
        System.out.println("Requested task is succesfully deleted from the tasklist");
        System.out.println("Latest tasklist is displayed below");
        showtasks();

    }

    public void showtasks()
    {

        Task task = new Task();
        System.out.println("taskname  duedate  project  status");
        for(int i =0;i<taskList.size();i++)
        {
            System.out.println(i+ ":" +taskList.get(i).taskname+"  "+taskList.get(i).duedate+
                    "  "+taskList.get(i).project+ "  "+taskList.get(i).status);

        }

    }


}
