package tasktests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import tasksmanagement.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class FileOperationsTest has testcases to verify the functionalities of the methods in FileOperations class
 */

public class FileOperationsTest<t> {

    String title = "packing";
    String project = "holiday";
    LocalDate duedate = LocalDate.ofEpochDay(2019 - 10 - 06);
    String status = "started";

    FileOperations file = new FileOperations();
    Task t = new Task(title, duedate, project, status);
    List<Task> tasklist = new ArrayList<>();

    /**
     * verifyWriteToFile() Testcase verifies the writeToFile() functionality
     */
    @Test
    public void verifyWriteToFile() {
        tasklist.add(t);
        tasklist.add(t);                         //Task t has been added to tasklist twice so the size of it at this moment is 2
        boolean fileadded = file.writeToFile("TestTaskList.txt", tasklist);
        Assert.assertTrue(fileadded);

    }

    /**
     * verifyReadFromFile() Test verifies the ReadFromFile() functionality
     */
    @Test
    public void verifyReadFromFile() {

        ArrayList<Task> readtasklist = (ArrayList<Task>) file.readFromFile("TestTaskList.txt");
        int listlength = readtasklist.size();
        Assert.assertTrue(listlength == 2);      //since t Task has been added twice, length of it at this stage should be 2

    }

}
