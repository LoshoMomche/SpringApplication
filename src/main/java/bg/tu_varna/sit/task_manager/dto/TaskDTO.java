package bg.tu_varna.sit.task_manager.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TaskDTO {
  private Long id;
  private String summary;
  private String description;
  private LocalDateTime deadLine;
}
