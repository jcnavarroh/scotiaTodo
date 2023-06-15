package com.scotia.todo.web.controller;

import com.scotia.todo.domain.Todo;
import com.scotia.todo.domain.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/all")
    public List<Todo> getAll() {
        return todoService.getAll();
    }

    @GetMapping("/{todoId}")
    public Optional<Todo> getTodo(@PathVariable("todoId") int todoId) {
        return todoService.getTodo(todoId);
    }

    @GetMapping("/state/{stateId}")
    public Optional<List<Todo>> getByState(@PathVariable("stateId") int stateId) {
        return todoService.getByState(stateId);
    }

    @PostMapping("/save")
    public Todo save(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @DeleteMapping("/delete/{todoId}")
    public boolean delete(@PathVariable("todoId") int todoId) {
        return todoService.delete(todoId);
    }
}
