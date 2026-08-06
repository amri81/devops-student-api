# DevOps Student API

## Projektübersicht

Dieses Repository enthält eine Spring-Boot-Anwendung mit einer REST-API zur Verwaltung von Aufgaben.

Der Schwerpunkt des Projekts liegt auf der Umsetzung einer vollständigen CI/CD-Pipeline mit GitHub Actions, Docker und Docker Compose.

## Technologien

- Java 21
- Spring Boot
- Apache Maven
- Git
- GitHub
- GitHub Actions
- Docker
- Docker Compose
- Docker Hub

---

## GitHub Repository

https://github.com/amri81/devops-student-api

## Docker Hub Repository

nouamanamri/devops-student-api

---

# Projektstruktur

```
.
├── .github/workflows/github-ci.yml
├── src/
├── Dockerfile
├── compose.yaml
├── pom.xml
└── README.md
```

---

# CI/CD Pipeline

Bei jedem Push oder Pull Request auf den **main**-Branch führt GitHub Actions automatisch folgende Schritte aus:

1. Repository auschecken
2. Java 21 installieren
3. Maven-Abhängigkeiten laden
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

Docker Image erstellen

```bash
docker build -t devops-student-api:latest .
```

Container starten

```bash
docker run -p 8080:8080 devops-student-api:latest
```

---

# Docker Compose

Container starten

```bash
docker compose up -d
```

Container anzeigen

```bash
docker compose ps
```

Container stoppen

```bash
docker compose down
```

---

# REST API

Beispiel

```
GET http://localhost:8080/api/tasks
```

---

# Autor

**Nouaman Amri**

Frankfurt University of Applied Sciences

Modul: DevOps

Jahr: 2026
