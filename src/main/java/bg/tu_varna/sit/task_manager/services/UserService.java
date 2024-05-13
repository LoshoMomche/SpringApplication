package bg.tu_varna.sit.task_manager.services;

import bg.tu_varna.sit.task_manager.dto.UserDTO;

public interface UserService {
  UserDTO create(UserDTO dto);
}
