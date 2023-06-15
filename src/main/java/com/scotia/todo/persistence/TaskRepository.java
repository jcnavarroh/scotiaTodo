package com.scotia.todo.persistence;

import com.scotia.todo.persistence.crud.TaskCrudRepository;
import com.scotia.todo.persistence.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepository {
    private TaskCrudRepository taskCrudRepository;

    public List<Task> getAll() {
        return (List<Task>) taskCrudRepository.findAll();
    }

    public List<Task> getByStatus(int idStatus) {
        //Query Method to request filter results by status
        return taskCrudRepository.findByIdStatusOrderByCreatedAtAsc(idStatus);

    }
    public Optional<Task> getTask(int idTask) {
        return taskCrudRepository.findById(idTask);
    }

    public Task save(Task task) {
        return taskCrudRepository.save(task);
    }

    public void delete(int idTask) {
        taskCrudRepository.deleteById(idTask);
    }
}
