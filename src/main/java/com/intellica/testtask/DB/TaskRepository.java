package com.intellica.testtask.DB;

import com.intellica.testtask.DB.Entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TaskRepository extends CrudRepository<Task, UUID> {
    Task findAllByOrderByLastNameAsc();

    Task findAllByOrderByLastNameDesc();

    Task findAllByOrderByFirstNameAsc();

    Task findAllByOrderByFirstNameDesc();

    Task findAllByOrderByDateAsc();

    Task findAllByOrderByDateDesc();
}
