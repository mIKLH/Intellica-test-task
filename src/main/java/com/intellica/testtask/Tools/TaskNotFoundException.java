package com.intellica.testtask.Tools;

import java.util.UUID;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(UUID id) {
        super("Could not find employee " + id);
    }
}
