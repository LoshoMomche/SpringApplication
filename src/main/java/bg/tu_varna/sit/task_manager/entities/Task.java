package bg.tu_varna.sit.task_manager.entities;

import bg.tu_varna.sit.task_manager.dto.ReportDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "summary", nullable = false)
  private String summary;
  @Column(name = "description", nullable = false)
  private String description;
  @Column(name = "deadline", nullable = false)
  private LocalDateTime deadline;

  @OneToMany
  private Set<Report> reports;
}
