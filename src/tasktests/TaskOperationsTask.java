package tasktests;

import tasksmanagement.TaskOperations;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TaskOperationsTask {

    String datestring = "2018-09-10";
    TaskOperations tasks = new TaskOperations();

    @Test
    public void verifyStringToDateConversion()
    {
        LocalDate datelocal = tasks.convertStringToDate(datestring);
        Assert.assertTrue(datelocal.toString().equals(datestring));
    }


}
