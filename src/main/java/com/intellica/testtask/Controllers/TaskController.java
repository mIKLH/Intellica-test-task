package com.intellica.testtask.Controllers;

import com.intellica.testtask.DB.Entities.Task;
import com.intellica.testtask.DB.TaskRepository;
import com.intellica.testtask.Services.TaskService;
import com.intellica.testtask.Tools.TaskNotFoundException;
import com.intellica.testtask.Tools.TaskResourceAssembler;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class TaskController {

    private TaskService taskService;
    private TaskRepository repository;
    private TaskResourceAssembler assembler;

    public TaskController(TaskService taskService, TaskRepository repository, TaskResourceAssembler assembler) {
        this.taskService = taskService;
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/task")
    public Resources<Resource<Task>> getAllTasks() {
        List<Resource<Task>> tasks = StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(tasks,
                linkTo(methodOn(TaskController.class).getAllTasks()).withSelfRel());
    }

    @GetMapping("/task/{id}")
    public Resource<Task> findById(@PathVariable UUID id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));

        return assembler.toResource(task);
    }

    @PostMapping("/task")
    public ResponseEntity<?> newTask(@Valid @RequestBody Task newTask) throws URISyntaxException {
        return taskService.createTask(newTask);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<?> updateTask(@Valid @RequestBody Task newTask, @PathVariable UUID id) throws URISyntaxException {
        return taskService.updateTask(newTask, id);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable UUID id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
