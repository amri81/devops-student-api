package de.devops.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class DevOpsTaskController {

    private final DevOpsTaskRepository repository;

    public DevOpsTaskController(DevOpsTaskRepository repository) {
        this.repository = repository;
    }

    /**
     * Gibt alle gespeicherten DevOps-Aufgaben aus PostgreSQL zurück.
     *
     * Beispiel:
     * GET /api/tasks
     */
    @GetMapping
    public List<DevOpsTask> getAllTasks() {
        return repository.findAll();
    }

    /**
     * Erstellt eine neue DevOps-Aufgabe und speichert sie in PostgreSQL.
     *
     * Beispiel:
     * POST /api/tasks
     * Body: Docker Compose konfigurieren
     */
    @PostMapping
    public DevOpsTask addTask(@RequestBody String description) {

        String cleanedDescription = description.trim();

        if (cleanedDescription.isEmpty()) {
            throw new IllegalArgumentException("Task must not be empty.");
        }

        DevOpsTask task = new DevOpsTask(cleanedDescription);

        return repository.save(task);
    }

    /**
     * Löscht eine DevOps-Aufgabe anhand ihrer Datenbank-ID.
     *
     * Beispiel:
     * DELETE /api/tasks/1
     */
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {

        if (!repository.existsById(id)) {
            return "Error: Task with ID " + id + " does not exist.";
        }

        repository.deleteById(id);

        return "DevOps task deleted successfully.";
    }
}