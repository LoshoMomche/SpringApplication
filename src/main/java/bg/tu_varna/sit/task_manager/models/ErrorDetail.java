package bg.tu_varna.sit.task_manager.models;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Getter
public class ErrorDetail {
  private LocalDateTime timestamp;
  private  String error;
  private HttpStatus status;
}
