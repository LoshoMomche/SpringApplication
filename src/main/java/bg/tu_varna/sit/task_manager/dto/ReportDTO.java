package bg.tu_varna.sit.task_manager.dto;

import bg.tu_varna.sit.task_manager.entities.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReportDTO {
  private Long id;
  private String content;
  private Short hoursWorked;
  private LocalDateTime dateCreated;
  private LocalDateTime dateUpdated;
  private Task task;
}
