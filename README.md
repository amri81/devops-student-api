# DevOps Student API

## Projektübersicht

Dieses Repository enthält eine funktionsfähige Spring-Boot-Anwendung mit einer REST-API zur Verwaltung von Aufgaben. Der Fokus liegt auf Continuous Integration und Continuous Deployment (CI/CD) mit GitHub Actions, Docker und Docker Hub.

Das Projekt dient als praktisches Beispiel für einen vollständigen DevOps-Workflow:

* Lokale Entwicklung mit Git und GitHub
* Automatisierte Builds und Tests mit GitHub Actions
* Docker-Containerisierung der Anwendung
* Veröffentlichung des Docker Images auf Docker Hub
* Einfache Nutzung über Docker Desktop

---

## Technologie-Stack

* Programmiersprache: Java 21
* Framework: Spring Boot
* Build-Tool: Apache Maven
* Versionsverwaltung: Git & GitHub
* CI/CD: GitHub Actions
* Containerisierung: Docker
* Container Registry: Docker Hub

Docker Hub Repository:

nouamanamri/devops-student-api

GitHub Repository:

https://github.com/amri81/devops-student-api

---

## Lokale Entwicklung

Repository klonen:

```bash
git clone https://github.com/amri81/devops-student-api.git
cd devops-student-api
```

Build durchführen:

```bash
.\mvnw.cmd clean package
```

Anwendung starten:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

---

## Docker

Docker Image bauen:

```bash
docker build -t devops-student-api:latest .
```

Container starten:

```bash
docker run -p 8080:8080 --name devops-student-api devops-student-api:latest
```

Docker Hub Image herunterladen:

```bash
docker pull nouamanamri/devops-student-api:latest
```

Docker Container starten:

```bash
docker run -p 8080:8080 --name devops-student-api nouamanamri/devops-student-api:latest
```

---

## Projekt

DevOps Student API

Erstellt von:

* Nouaman Amri

Jahr: 2026
