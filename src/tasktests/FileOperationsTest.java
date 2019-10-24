package tasktests;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import Tasksmanagement.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileOperationsTest<t> {

    String title = "packing";
    String project = "holiday";
    LocalDate duedate = LocalDate.ofEpochDay(2019-10-06);
    String status = "started";

    FileOperations file = new FileOperations();
    Task t = new Task(title,duedate,project,status);
    List<Task> tasklist = new ArrayList<>();

    @Test
    public void verifyWriteToFile()
    {
        tasklist.add(t);
        tasklist.add(t);
        boolean fileadded =  file.writeToFile("TestTaskList.txt", tasklist);
        Assert.assertTrue(fileadded);

    }

    @Test
    public void verifyReadFromFile()
    {
       ArrayList<Task> readtasklist = (ArrayList<Task>) file.readFromFile("TestTaskList.txt");
       int listlength = readtasklist.size();
       Assert.assertTrue(listlength==2);

    }

}
