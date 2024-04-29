package bg.tu_varna.sit.task_manager.controllers;

import bg.tu_varna.sit.task_manager.exceptions.TaskNotFoundException;
import bg.tu_varna.sit.task_manager.models.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(TaskNotFoundException.class)
  public ResponseEntity<ErrorDetail> handleTaskFoundException(TaskNotFoundException exception){
    ErrorDetail detail= ErrorDetail
        .builder()
        .timestamp(LocalDateTime.now())
        .status(HttpStatus.NOT_FOUND)
        .error(exception.getMessage())
        .build();

    return new ResponseEntity<>(detail,HttpStatus.NOT_FOUND);
  }
}
