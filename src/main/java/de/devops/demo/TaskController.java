package de.devops.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    // einfache In-Memory-"Datenbank"
    private final List<String> tasks = new ArrayList<>();

    // Alle Aufgaben lesen
    @GetMapping
    public List<String> getAllTasks() {
        return tasks;
    }

    // Neue Aufgabe hinzufügen
    @PostMapping
    public String addTask(@RequestBody String task) {
        tasks.add(task);
        return "Task added: " + task;
    }

    // Eine Aufgabe nach Index löschen
    @DeleteMapping("/{index}")
    public String deleteTask(@PathVariable int index) {
        if (index < 0 || index >= tasks.size()) {
            return "Invalid index: " + index;
        }
        String removed = tasks.remove(index);
        return "Task removed: " + removed;
    }
}
