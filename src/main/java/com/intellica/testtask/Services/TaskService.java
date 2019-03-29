package com.intellica.testtask.Services;

import com.intellica.testtask.DB.Entities.Task;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.UUID;


public interface TaskService {
    ResponseEntity<?> createTask(Task task) throws URISyntaxException;

    ResponseEntity<?> updateTask(Task task, UUID id) throws URISyntaxException;

}
