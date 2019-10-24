package tasktests;

import org.junit.jupiter.api.Order;
import tasksmanagement.Task;
import tasksmanagement.TaskOperations;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskOperationsTest {

    String datestring = "2018-09-10";
    TaskOperations tasks = new TaskOperations();
    String title = "packing";
    String project = "holiday";
    LocalDate duedate = LocalDate.ofEpochDay(2019-10-06);
    String status = "started";
    Task t = new Task(title,duedate,project,status);
    ArrayList<Task> tasklist = new ArrayList<>();

    @Test
    @Order(1)
    public void verifyStringToDateConversion()
    {
        LocalDate datelocal = tasks.convertStringToDate(datestring);
        Assert.assertTrue(datelocal.toString().equals(datestring));
    }

    @Test
    @Order(2)
    public void verifyAddAndEditTask() throws IOException
    {
        try {
            tasklist = tasks.addTask(t,tasklist);
        } catch (IOException e) {
            e.printStackTrace();
        }
       Assert.assertTrue(tasklist.get(tasklist.size()-1).title.equals(title));
       Assert.assertTrue(tasklist.get(tasklist.size()-1).duedate.equals(duedate));
       Assert.assertTrue(tasklist.get(tasklist.size()-1).project.equals(project));
       Assert.assertTrue(tasklist.get(tasklist.size()-1).status.equals(status));

       tasklist=tasks.editTask(tasklist.size()-1,"title","chandanapacking",tasklist);
       Assert.assertTrue(tasklist.get(tasklist.size()-1).title.equals("chandanapacking"));

    }




}
