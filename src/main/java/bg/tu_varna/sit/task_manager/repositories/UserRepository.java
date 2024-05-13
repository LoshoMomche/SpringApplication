package bg.tu_varna.sit.task_manager.repositories;

import bg.tu_varna.sit.task_manager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
