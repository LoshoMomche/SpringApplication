package bg.tu_varna.sit.task_manager.services;

import bg.tu_varna.sit.task_manager.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService  extends UserDetailsService {
  UserDTO create(UserDTO dto);
  UserDTO readByEmail(String email);
}
