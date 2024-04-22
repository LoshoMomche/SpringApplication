package bg.tu_varna.sit.task_manager.services;

import bg.tu_varna.sit.task_manager.dto.TaskDTO;
import bg.tu_varna.sit.task_manager.repositories.TaskRepository;

public class TaskServiceImp implements TaskService{

    private TaskRepository repository;


    @Override
    public TaskDTO create(TaskDTO dto) {
        return repository.save(dto);
    }
}
