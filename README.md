# DevOps Student API

## Projektübersicht

Die **DevOps Student API** ist eine Spring-Boot-Anwendung zur Verwaltung von Aufgaben (Tasks).

Das Projekt demonstriert die Umsetzung einer modernen DevOps-Pipeline mit:

- Spring Boot
- Maven
- Git & GitHub
- GitHub Actions
- Docker
- Docker Compose
- Docker Swarm
- Portainer

Die Anwendung wird als Docker-Container ausgeführt und kann über Portainer verwaltet werden.

---

# Technologien

- Java 21
- Spring Boot 3
- Apache Maven
- REST API
- Git
- GitHub
- GitHub Actions
- Docker
- Docker Compose
- Docker Swarm
- Portainer Community Edition

---

# GitHub Repository

https://github.com/amri81/devops-student-api

---

# Docker Hub Repository

https://hub.docker.com/r/nouamanamri/devops-student-api

---

# Projektstruktur

```text
.
├── .github/
│   └── workflows/
│       └── github-ci.yml
├── src/
├── Dockerfile
├── compose.yaml
├── pom.xml
├── README.md
└── target/
```

---

# CI/CD Pipeline

Bei jedem Push oder Pull Request auf den **main**-Branch führt GitHub Actions automatisch folgende Schritte aus:

1. Repository auschecken
2. Java 21 installieren
3. Maven-Abhängigkeiten herunterladen
4. Automatisierte Tests ausführen
5. Spring-Boot-Anwendung bauen
6. Docker-Image erstellen
7. Docker Compose validieren
8. Anwendung mit Docker Compose starten
9. REST-API testen
10. Laufende Container anzeigen
11. Docker-Umgebung wieder stoppen

Dadurch wird sichergestellt, dass jede Änderung automatisch überprüft wird.

---

# Anwendung lokal starten

Repository klonen

```bash
git clone https://github.com/amri81/devops-student-api.git

cd devops-student-api
```

Projekt bauen

```bash
./mvnw clean package
```

Anwendung starten

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

---

# Docker

Docker-Image erstellen

```bash
docker build -t devops-student-api:latest .
```

Docker-Container starten

```bash
docker run -p 8080:8080 devops-student-api:latest
```

Images anzeigen

```bash
docker images
```

Laufende Container anzeigen

```bash
docker ps
```

---

# Docker Compose

Container starten

```bash
docker compose up --build -d
```

Container anzeigen

```bash
docker compose ps
```

Logs anzeigen

```bash
docker compose logs
```

Container stoppen

```bash
docker compose down
```

---

# Docker Swarm

Swarm initialisieren

```bash
docker swarm init
```

Swarm-Status anzeigen

```bash
docker node ls
```

---

# Portainer

Portainer wird über Docker Compose gestartet.

Weboberfläche

```
https://localhost:9443
```

Mit Portainer können folgende Ressourcen verwaltet werden:

- Stacks
- Container
- Images
- Networks
- Volumes
- Logs
- Docker Swarm

---

# REST API

## Startseite

```
http://localhost:8080
```

---

## Alle Aufgaben abrufen

```http
GET /api/tasks
```

Beispiel

```
http://localhost:8080/api/tasks
```

Beispielantwort

```json
[]
```

---

# Projekt starten

```bash
docker compose up --build -d
```

Anwendung öffnen

```
http://localhost:8080
```

Portainer öffnen

```
https://localhost:9443
```

---

# Screenshots

Empfohlene Screenshots:

- Docker Compose
- Portainer Dashboard
- Docker Swarm
- Container Logs
- REST API
- Anwendung im Browser

---

# Autor

**Nouaman Amri**

Technische Hochschule Mittelhessen (THM)

Campus Friedberg

Modul: Software Development and Operations

Jahr: 2026
