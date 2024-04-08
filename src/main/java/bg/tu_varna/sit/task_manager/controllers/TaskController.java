package bg.tu_varna.sit.task_manager.controllers;

import bg.tu_varna.sit.task_manager.dto.TaskDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

  @GetMapping
    public ResponseEntity<List<TaskDTO>> getTasks() {
      List<TaskDTO> taskDTOS = List.of(
          new TaskDTO(),
          new TaskDTO()
      );

      return new ResponseEntity<>(taskDTOS, HttpStatus.OK);
    }
}
