package bg.tu_varna.sit.task_manager.services;

import bg.tu_varna.sit.task_manager.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO create(TaskDTO dto);
    TaskDTO read(Long id);

    List<TaskDTO> readAll();

    void deleteByID(Long id);
}
