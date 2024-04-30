package bg.tu_varna.sit.task_manager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class TaskDTO {
  private Long id;
  @NotBlank(message = "Summary cannot be blank.")
  private String summary;
  @NotBlank(message = "Description cannot be blank.")
  private String description;
  @NotNull(message = "Deadline cannot be null.")
  private LocalDateTime deadline;
  private Set<ReportDTO> reports;
}
