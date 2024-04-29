package bg.tu_varna.sit.task_manager.services;

import bg.tu_varna.sit.task_manager.dto.TaskDTO;
import bg.tu_varna.sit.task_manager.entities.Task;
import bg.tu_varna.sit.task_manager.exceptions.TaskNotFoundException;
import bg.tu_varna.sit.task_manager.repositories.TaskRepository;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService {

  private final TaskRepository repository;

  private final ModelMapper mapper;

  public TaskServiceImp(TaskRepository repository, ModelMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public TaskDTO create(TaskDTO dto) {
    Task task = mapper.map(dto, Task.class);

    task = repository.save(task);

    return mapper.map(task, TaskDTO.class);
  }

  @SneakyThrows
  @Override
  public TaskDTO read(Long id) {
    Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException("id",id));

    return mapper.map(task, TaskDTO.class);
  }

  @Override
  public List<TaskDTO> readAll() {
    List<Task> tasks = repository.findAll();

    return mapper.map(tasks, new TypeToken<List<TaskDTO>>() {
    }.getType());
  }
}
