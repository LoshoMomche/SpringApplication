package bg.tu_varna.sit.task_manager.entities;


import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "role_types")
public enum RoleType {
  ADMIN,
  MANAGER,
  DEVELOPER;


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


}
