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
            <title>DevOps Student API</title>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    margin: 50px;
                    background-color: #f5f5f5;
                }

                .container {
                    max-width: 800px;
                    margin: auto;
                    background: white;
                    padding: 30px;
                    border-radius: 10px;
                    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
                }

                h1 {
                    color: #0d6efd;
                }

                a {
                    color: #0d6efd;
                    text-decoration: none;
                    font-size: 18px;
                    font-weight: bold;
                }

                a:hover {
                    text-decoration: underline;
                }

                p {
                    font-size: 18px;
                }
            </style>
        </head>

        <body>

        <div class="container">

            <h1>DevOps Student API</h1>

            <p>
                Willkommen zur DevOps Student API.
            </p>

            <p>
                Dieses Projekt demonstriert eine moderne DevOps-Pipeline mit
                Spring Boot, Maven, GitHub Actions und Docker.
            </p>

            <p>
                <a href="/api/tasks">→ API öffnen</a>
            </p>

        </div>

        </body>
        </html>
        """;
    }
}