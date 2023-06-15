package com.scotia.todo.persistence;

import com.scotia.todo.domain.Todo;
import com.scotia.todo.domain.repository.TodoRepository;
import com.scotia.todo.persistence.crud.TaskCrudRepository;
import com.scotia.todo.persistence.entity.Task;
import com.scotia.todo.persistence.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository implements TodoRepository {

    @Autowired
    private TaskCrudRepository taskCrudRepository;

    @Autowired
    private TodoMapper mapper;
    @Override
    public List<Todo> getAll() {

        List<Task> tasks = (List<Task>) taskCrudRepository.findAll();
        return mapper.toTodos(tasks);
    }
    @Override
    public Optional<List<Todo>> getByState(int stateId) {
        //Query Method to request filter results by status
        List<Task> Tasks = taskCrudRepository.findByIdStatusOrderByCreatedAtAsc(stateId);
        return Optional.of(mapper.toTodos(Tasks));
    }
    @Override
    public Optional<Todo> getTodo(int todoId) {
        return taskCrudRepository.findById(todoId).map(task -> mapper.toTodo(task));
    }

    @Override
    public Todo save(Todo todo) {
        Task task = mapper.toTask(todo);
        return mapper.toTodo(taskCrudRepository.save(task));
    }
    @Override
    public void delete(int todoId) {
        taskCrudRepository.deleteById(todoId);
    }
}
