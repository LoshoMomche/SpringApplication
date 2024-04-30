package bg.tu_varna.sit.task_manager.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "email", unique = true, nullable = false)
  private String email;
  @Column(name = "password", nullable = false)
  private String password;
}
