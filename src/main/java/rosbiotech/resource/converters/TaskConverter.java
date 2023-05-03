package rosbiotech.resource.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import rosbiotech.resource.dtos.TaskDto;
import rosbiotech.resource.entities.Task;

@Component
@RequiredArgsConstructor
public class TaskConverter {

    public TaskDto entityToDto(Task task) {
        return new TaskDto(task.getId(), task.getTitle(), task.getDescription());
    }
}
