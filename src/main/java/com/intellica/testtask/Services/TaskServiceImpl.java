package com.intellica.testtask.Services;

import com.intellica.testtask.DB.Entities.Task;
import com.intellica.testtask.DB.TaskRepository;
import com.intellica.testtask.Tools.TaskResourceAssembler;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskResourceAssembler assembler;
    private TaskRepository repository;

    public TaskServiceImpl(TaskResourceAssembler assembler, TaskRepository repository) {
        this.assembler = assembler;
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> createTask(Task newTask) throws URISyntaxException {

        if (newTask.getId() == null) newTask.setId(UUID.randomUUID());

        Resource<Task> resource = assembler.toResource(repository.save(newTask));

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    @Override
    public ResponseEntity<?> updateTask(Task newTask, UUID id) throws URISyntaxException {

        Task updatedTask = repository.findById(id)
                .map(task -> {
                    task.setFirstName(newTask.getFirstName());
                    task.setLastName(newTask.getLastName());
                    task.setDate(newTask.getDate());
                    task.setTitle(newTask.getTitle());

                    return repository.save(task);
                })
                .orElseGet(() -> {
                    newTask.setId(id);
                    return repository.save(newTask);
                });

        Resource<Task> resource = assembler.toResource(updatedTask);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }
}
