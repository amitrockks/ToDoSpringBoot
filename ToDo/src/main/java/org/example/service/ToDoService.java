package org.example.service;

import org.example.model.ToDo;
import org.example.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository repository;

    public ToDo createTask(ToDo task) {
        return repository.save(task);
    }

    public List<ToDo> getAllTasks() {
        return repository.findAll();
    }

    public Optional<ToDo> getTaskById(Integer id) {
        return repository.findById(id);
    }

    public ToDo updateTask(Integer id, ToDo taskDetails) {
        return repository.findById(id).map(task -> {
            task.setTitle(taskDetails.getTitle());
            task.setStatus(taskDetails.isStatus());
            return repository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    public String deleteTask(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Task with id " + id + " deleted successfully.";
        } else {
            return "Task not found with id " + id;
        }
    }
}
