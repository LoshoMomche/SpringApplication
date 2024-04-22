package bg.tu_varna.sit.task_manager.repositories;

import bg.tu_varna.sit.task_manager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
