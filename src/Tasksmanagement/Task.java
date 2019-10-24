package Tasksmanagement;

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
    String title;
    LocalDate duedate;
    String project;
    String status;



}
