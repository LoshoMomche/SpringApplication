package bg.tu_varna.sit.task_manager.controllers;

import bg.tu_varna.sit.task_manager.dto.LoginRequestDTO;
import bg.tu_varna.sit.task_manager.dto.UserDTO;
import bg.tu_varna.sit.task_manager.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService service;

  private final AuthenticationManager authenticationManager;

  public UserController(UserService service,AuthenticationManager authenticationManager) {
    this.service = service;
    this.authenticationManager=authenticationManager;
  }

  @PostMapping("/create")
  public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
    return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO dto) {

    Authentication authentication= authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getPassword()));

    SecurityContext sc = SecurityContextHolder.getContext();
    sc.setAuthentication(authentication);

    UserDTO userDTO=new UserDTO();
    userDTO.setEmail(dto.getEmail());

    return new ResponseEntity<>(userDTO, HttpStatus.OK);
  }
}
