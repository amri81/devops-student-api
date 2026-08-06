package de.devops.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class DevOpsTaskController {

    // Temporärer In-Memory-Speicher für DevOps-Aufgaben.
    // Die Daten gehen beim Neustart der Anwendung verloren.
    private final List<String> tasks = new ArrayList<>();

    /**
     * Gibt alle gespeicherten DevOps-Aufgaben zurück.
     *
     * Beispiel:
     * GET /api/tasks
     */
    @GetMapping
    public List<String> getAllTasks() {
        return tasks;
    }

    /**
     * Fügt eine neue DevOps-Aufgabe hinzu.
     *
     * Beispiel:
     * POST /api/tasks
     * Body: Docker Compose konfigurieren
     */
    @PostMapping
    public String addTask(@RequestBody String task) {
        String cleanedTask = task.trim();

        if (cleanedTask.isEmpty()) {
            return "Error: The DevOps task must not be empty.";
        }

        tasks.add(cleanedTask);

        return "DevOps task created successfully: " + cleanedTask;
    }

    /**
     * Löscht eine DevOps-Aufgabe anhand ihres Indexes.
     *
     * Beispiel:
     * DELETE /api/tasks/0
     */
    @DeleteMapping("/{index}")
    public String deleteTask(@PathVariable int index) {
        if (index < 0 || index >= tasks.size()) {
            return "Error: Invalid task index (" + index + ").";
        }

        String removedTask = tasks.remove(index);

        return "DevOps task deleted successfully: " + removedTask;
    }
}