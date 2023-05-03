package rosbiotech.resource.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rosbiotech.resource.entities.Task;
import rosbiotech.resource.dtos.TaskDto;
import rosbiotech.resource.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    public Optional<Task> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    public Task createNewTask(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        taskRepository.save(task);
        return task;
    }
}
