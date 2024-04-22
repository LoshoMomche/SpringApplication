package bg.tu_varna.sit.task_manager.services;

import bg.tu_varna.sit.task_manager.dto.TaskDTO;

public interface TaskService {

    TaskDTO create(TaskDTO dto);
}
