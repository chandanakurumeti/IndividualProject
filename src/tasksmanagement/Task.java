package tasksmanagement;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {

public Task(String title, LocalDate duedate, String project, String status)
{
    this.title = title;
    this.duedate = duedate;
    this.project = project;
    this.status = status;

}
public Task()
{

}
    public String title;
    public LocalDate duedate;
    public String project;
    public String status;



}
