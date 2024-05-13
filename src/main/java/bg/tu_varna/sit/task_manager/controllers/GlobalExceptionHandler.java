package bg.tu_varna.sit.task_manager.controllers;

import bg.tu_varna.sit.task_manager.exceptions.TaskNotFoundException;
import bg.tu_varna.sit.task_manager.models.ErrorDetail;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;

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

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    List<ErrorDetail> errorDetails= ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(e -> ErrorDetail.builder()
            .error(e.getDefaultMessage())
            .status(HttpStatus.BAD_REQUEST)
            .timestamp(LocalDateTime.now())
            .build())
        .toList();

    return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
  }

}
