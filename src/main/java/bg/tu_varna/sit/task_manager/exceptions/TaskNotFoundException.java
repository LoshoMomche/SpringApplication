package bg.tu_varna.sit.task_manager.exceptions;

public class TaskNotFoundException extends Exception{
  public TaskNotFoundException(String field,Object value){
    super(String.format("Task with %s %s not found:",field,value));
  }
}
