package bg.tu_varna.sit.task_manager.controllers;

import bg.tu_varna.sit.task_manager.dto.UserDTO;
import bg.tu_varna.sit.task_manager.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService service;

  public UserController(UserService service) {
    this.service = service;
  }

  @PostMapping("/create")
  public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto){
    return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
  }
}
