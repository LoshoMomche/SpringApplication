package bg.tu_varna.sit.task_manager.dto;

import bg.tu_varna.sit.task_manager.entities.RoleType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserDTO {
  @NotBlank(message = "Name cannot be blank.")
  private String name;
  @Email(message = "Invalid email.")
  private String email;
  @NotBlank(message = "Password cannot be blank.")
  private String password;
  @NotEmpty(message = "User must have at least one role.")
  private Set<RoleType> roles;
}
