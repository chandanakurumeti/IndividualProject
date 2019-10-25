package tasksmanagement;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * This Class Task implements serializable to use the FileOutputStream,ObjectOutputStream,FileInputStream and ObjectInputStream classes in the package
 * This class has parameterised constructor to initialise the object of it.
 */

public class Task implements Serializable {

    public Task(String title, LocalDate duedate, String project, String status) {
        this.title = title;
        this.duedate = duedate;
        this.project = project;
        this.status = status;

    }

    public Task() {

    }

    public String title;
    public LocalDate duedate;
    public String project;
    public String status;


}
