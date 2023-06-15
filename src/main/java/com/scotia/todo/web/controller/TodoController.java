package com.scotia.todo.web.controller;

import com.scotia.todo.domain.Todo;
import com.scotia.todo.domain.service.TodoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/all")
    @ApiOperation("Get all todos")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Todo>> getAll() {
        return new ResponseEntity<>(todoService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{todoId}")
    @ApiOperation("Get an specific TODO using ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "TODO not found"),
    })
    public ResponseEntity<Todo> getTodo(@ApiParam(value = "The id of the TODO", required = true, example = "2") @PathVariable("todoId") int todoId) {
        return todoService.getTodo(todoId).map(Todo -> new ResponseEntity<>(Todo, HttpStatus.OK )).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/state/{stateId}")
    @ApiOperation("Get all TODOs filter by State")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "TODOs not found"),
    })
    public ResponseEntity<List<Todo>> getByState(@PathVariable("stateId") int stateId) {
        return todoService.getByState(stateId).map(Todo -> new ResponseEntity<>(Todo, HttpStatus.OK )).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Create a new TODO or modify existing TODO")
    @ApiResponse(code = 201, message = "CREATED")
    public ResponseEntity<Todo> save(@RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.save(todo), HttpStatus.CREATED );
    }

    @DeleteMapping("/delete/{todoId}")
    @ApiOperation("Delete TODO by ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "DELETED OK"),
            @ApiResponse(code = 404, message = "TODO not found"),
    })
    public ResponseEntity delete(@PathVariable("todoId") int todoId) {
        if(todoService.delete(todoId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
