package bg.tu_varna.sit.task_manager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class LoginRequestDTO {
  @Email
  private String email;
  @NotBlank @Min(8)
  private String password;
}
