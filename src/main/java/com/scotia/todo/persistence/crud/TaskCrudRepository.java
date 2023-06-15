package com.scotia.todo.persistence.crud;

import com.scotia.todo.persistence.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskCrudRepository extends CrudRepository<Task, Integer> {

    List<Task> findByIdStatusOrderByCreatedAtAsc(int idStatus);

}
