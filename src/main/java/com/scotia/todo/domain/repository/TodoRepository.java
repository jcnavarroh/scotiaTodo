package com.scotia.todo.domain.repository;

import com.scotia.todo.domain.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    List<Todo> getAll();

    Optional<List<Todo>> getByState(int stateId);

    Optional<Todo> getTodo(int todoId);

    Todo save(Todo todo);

    void delete(int todoId);


}
