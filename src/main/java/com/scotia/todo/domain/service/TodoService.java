package com.scotia.todo.domain.service;

import com.scotia.todo.domain.Todo;
import com.scotia.todo.domain.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAll() {
        return todoRepository.getAll();
    }

    public Optional<Todo> getTodo(int todoId) {
        return todoRepository.getTodo(todoId);
    }

    public Optional<List<Todo>> getByState(int stateId) {
        return todoRepository.getByState(stateId);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public boolean delete(int todoId) {
        return getTodo(todoId).map(todo -> {
            todoRepository.delete(todoId);
            return true;
        }).orElse(false);
    }
}
