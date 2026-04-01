package org.example.controller;

import org.example.model.ToDo;
import org.example.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoController {

    @Autowired
    private ToDoService service;

    @PostMapping("/createToDo")
    public ToDo createToDo(@RequestBody ToDo task) {
        return service.createTask(task);
    }

    @GetMapping("/getAll")
    public List<ToDo> getAll() {
        return service.getAllTasks();
    }

    @GetMapping("/getTask/{id}")
    public ResponseEntity<ToDo> getTaskById(@PathVariable Integer id) {
        return service.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/upstateTask/{id}")
    public ToDo updateTask(@PathVariable Integer id, @RequestBody ToDo task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("/deleteTask/{id}")
    public String deleteToDo(@PathVariable Integer id) {
        return service.deleteTask(id);
    }
}
