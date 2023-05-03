package rosbiotech.resource.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rosbiotech.resource.converters.TaskConverter;
import rosbiotech.resource.dtos.TaskDto;
import rosbiotech.resource.entities.Task;
import rosbiotech.resource.exceptions.ResourceNotFoundException;
import rosbiotech.resource.services.TaskService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService taskService;
    private final TaskConverter taskConverter;

    @GetMapping
    public List<TaskDto> getAll() {
        return taskService.getAll().stream().map(taskConverter::entityToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        Task task = taskService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
        return taskConverter.entityToDto(task);
    }

    @PostMapping("/create")
    public TaskDto createNewTask(@RequestBody TaskDto taskDto) {
        Task task = taskService.createNewTask(taskDto);
        return taskConverter.entityToDto(task);
    }
}
