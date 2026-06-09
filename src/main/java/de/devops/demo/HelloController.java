package de.devops.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        return """
        <!DOCTYPE html>
        <html>
        <head>
            <title>DevOps Task API</title>
            <style>
                body { font-family: Arial, sans-serif; margin: 50px; }
                a { color: #0066cc; text-decoration: none; font-size: 18px; font-weight: bold; }
                a:hover { text-decoration: underline; }
            </style>
        </head>
        <body>
            <h1>Hello DevOps!</h1>
            <p>Willkommen zur Task-Verwaltungs-API.</p>
            <p><a href="/api/tasks">→ Zur Task-API</a></p>
        </body>
        </html>
        """;
    }
}
