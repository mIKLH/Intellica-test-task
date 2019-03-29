package com.intellica.testtask.Tools;

import com.intellica.testtask.Controllers.TaskController;
import com.intellica.testtask.DB.Entities.Task;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class TaskResourceAssembler implements ResourceAssembler<Task, Resource<Task>> {
    @Override
    public Resource<Task> toResource(Task task) {
        return new Resource<>(task,
                linkTo(methodOn(TaskController.class).findById(task.getId())).withSelfRel(),
                linkTo(methodOn(TaskController.class).getAllTasks()).withRel("task"));
    }
}
