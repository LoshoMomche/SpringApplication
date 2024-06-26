package bg.tu_varna.sit.task_manager.controllers;

import bg.tu_varna.sit.task_manager.dto.TaskDTO;
import bg.tu_varna.sit.task_manager.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {
  private final TaskService service;

  public TaskController(TaskService service) {
    this.service = service;
  }

  @PostMapping("/create")
  public ResponseEntity<TaskDTO> create(@Valid @RequestBody TaskDTO taskDTO) {
    TaskDTO result = service.create(taskDTO);

    return new ResponseEntity<>(result, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<TaskDTO> readByID(@PathVariable Long id) {
    return new ResponseEntity<>(service.read(id), HttpStatus.OK);
  }

  @GetMapping("/")
  public ResponseEntity<List<TaskDTO>> readAll() {
    return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> delete(@PathVariable Long id){
    service.deleteByID(id);
    return new ResponseEntity<>("",HttpStatus.NO_CONTENT);
  }
}
