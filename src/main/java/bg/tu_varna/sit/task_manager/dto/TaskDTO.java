package bg.tu_varna.sit.task_manager.dto;

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
  private String summary;
  private String description;
  private LocalDateTime deadline;
  private Set<ReportDTO> reports;
}
