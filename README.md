# DevOps Student API

## Projektübersicht

Die **DevOps Student API** ist eine Spring-Boot-Anwendung zur Verwaltung von Aufgaben (Tasks).

Das Projekt wurde im Rahmen des Moduls **Software Development and Operations** entwickelt und demonstriert den Aufbau einer modernen DevOps-Umgebung.

Im Mittelpunkt stehen die Automatisierung von Build, Test und Deployment sowie die Containerisierung und Verwaltung der Anwendung.

Das Projekt verwendet unter anderem:

- Spring Boot
- Maven
- Git & GitHub
- GitHub Actions
- Self-hosted GitHub Actions Runner
- Docker
- Docker Compose
- Docker Swarm
- PostgreSQL
- Portainer Community Edition

Die Anwendung wird als Docker-Container ausgeführt und kann über Portainer verwaltet und überwacht werden.

---

# Technologien

Für das Projekt werden folgende Technologien verwendet:

- Java 21
- Spring Boot 3
- Apache Maven
- REST API
- PostgreSQL
- Git
- GitHub
- GitHub Actions
- Self-hosted GitHub Actions Runner
- Docker
- Docker Compose
- Docker Swarm
- Portainer Community Edition
- Windows Service

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

Die wichtigsten Dateien sind:

### `github-ci.yml`

Enthält die Definition der GitHub-Actions-CI/CD-Pipeline.

### `Dockerfile`

Definiert das Docker-Image für die Spring-Boot-Anwendung.

### `compose.yaml`

Definiert die Docker-Compose-Umgebung und die benötigten Services.

### `pom.xml`

Enthält die Maven-Konfiguration und die Abhängigkeiten der Spring-Boot-Anwendung.

---

# DevOps-Architektur

Das Projekt verbindet mehrere DevOps-Komponenten miteinander.

Der grundlegende Ablauf sieht folgendermaßen aus:

```text
Developer
    |
    | Git Push
    v
GitHub Repository
    |
    v
GitHub Actions
    |
    +-----------------------+
    | Build, Test & Docker  |
    +-----------------------+
              |
              v
        Docker Image
              |
              v
     GitHub Actions Artifact
              |
              v
    Self-hosted Runner
              |
              v
        Docker Compose
              |
              v
    Spring Boot + PostgreSQL
              |
              v
          Portainer
```

Dadurch werden Entwicklung, Build, Test und Deployment miteinander verbunden.

---

# CI/CD Pipeline

Das Projekt verwendet **GitHub Actions** zur Automatisierung der CI/CD-Prozesse.

Die Pipeline besteht aus zwei Hauptphasen:

1. **Build, Test & Docker**
2. **Deployment mit Docker Compose**

---

## 1. Build, Test & Docker

Bei einer entsprechenden Änderung im GitHub Repository wird die CI-Pipeline gestartet.

Der erste Job führt unter anderem folgende Schritte aus:

1. Repository auschecken
2. Java 21 einrichten
3. Maven-Abhängigkeiten laden
4. automatisierte Tests ausführen
5. Spring-Boot-Anwendung bauen
6. Docker-Image erstellen
7. Docker-Image als GitHub-Actions-Artefakt bereitstellen

Der Build-Job muss erfolgreich abgeschlossen werden, bevor das Deployment gestartet wird.

---

## 2. Deployment mit Docker Compose

Nach erfolgreichem Build wird der Deployment-Job ausgeführt.

Für das Deployment wird ein **Self-hosted GitHub Actions Runner** verwendet.

Der Deployment-Prozess umfasst:

1. Repository auschecken
2. erzeugtes Docker-Image herunterladen
3. Docker-Image auf dem Self-hosted Runner laden
4. Anwendung mit Docker Compose starten bzw. aktualisieren
5. Deployment überprüfen
6. Status der laufenden Container kontrollieren

Der Ablauf kann vereinfacht so dargestellt werden:

```text
Git Push
   |
   v
GitHub Actions
   |
   v
Build & Test
   |
   v
Docker Image erstellen
   |
   v
Artifact speichern
   |
   v
Self-hosted Runner
   |
   v
Docker Image laden
   |
   v
Docker Compose Deployment
   |
   v
Anwendung läuft
```

Damit werden Continuous Integration und Continuous Deployment miteinander verbunden.

---

# Self-hosted GitHub Actions Runner

Für das automatische Deployment wird ein **Self-hosted GitHub Actions Runner** verwendet.

Der Runner läuft auf einem Windows-System und ist direkt mit dem GitHub Repository verbunden.

Die verwendeten Runner-Labels sind:

```text
self-hosted
Windows
X64
```

GitHub Actions kann dadurch Deployment-Jobs direkt auf der lokalen Docker-Umgebung ausführen.

---

## Runner als Windows-Service

Der Self-hosted Runner wurde zusätzlich als **Windows-Service** eingerichtet.

Dadurch muss der Runner nicht bei jedem Deployment manuell über

```powershell
.\run.cmd
```

gestartet werden.

Der Windows-Service kann beispielsweise mit PowerShell überprüft werden:

```powershell
Get-Service *actions*
```

Bei einem laufenden Runner sollte der Status ähnlich aussehen:

```text
Status   Name
------   ----
Running  actions.runner....
```

Der Runner steht dadurch für GitHub Actions als Deployment-Umgebung zur Verfügung.

---

# Automatischer Deployment-Ablauf

Der gewünschte Deployment-Prozess funktioniert nach folgendem Prinzip:

```text
Änderung am Projekt
        |
        v
Git Commit
        |
        v
Git Push
        |
        v
GitHub Actions startet
        |
        v
Build & Tests
        |
        v
Docker Image
        |
        v
Artifact
        |
        v
Self-hosted Runner
        |
        v
Docker Compose
        |
        v
Neue Anwendungsversion
```

Dadurch müssen Build und Deployment nicht mehr manuell Schritt für Schritt durchgeführt werden.

---

# Anwendung lokal starten

## Repository klonen

```bash
git clone https://github.com/amri81/devops-student-api.git
cd devops-student-api
```

---

## Projekt mit Maven bauen

```bash
./mvnw clean package
```

Unter Windows kann alternativ verwendet werden:

```powershell
.\mvnw.cmd clean package
```

Nach erfolgreichem Build befindet sich die erzeugte JAR-Datei im Verzeichnis:

```text
target/
```

---

## Anwendung ohne Docker starten

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

Die Anwendung ist anschließend unter folgendem Port erreichbar:

```text
http://localhost:8080
```

---

# Docker

Die Spring-Boot-Anwendung wird als Docker-Image containerisiert.

## Docker-Image erstellen

```bash
docker build -t devops-student-api:latest .
```

---

## Docker-Images anzeigen

```bash
docker images
```

---

## Docker-Container starten

```bash
docker run -p 8080:8080 devops-student-api:latest
```

---

## Laufende Container anzeigen

```bash
docker ps
```

---

## Alle Container anzeigen

```bash
docker ps -a
```

---

# Docker Compose

Docker Compose wird verwendet, um die benötigten Services gemeinsam zu starten und zu verwalten.

Die Umgebung umfasst unter anderem:

- Spring-Boot-Anwendung
- PostgreSQL

---

## Docker-Compose-Umgebung starten

```bash
docker compose up --build -d
```

---

## Container anzeigen

```bash
docker compose ps
```

---

## Logs anzeigen

```bash
docker compose logs
```

Für fortlaufende Logs:

```bash
docker compose logs -f
```

---

## Docker-Compose-Umgebung stoppen

```bash
docker compose down
```

---

# PostgreSQL

Für die persistente Speicherung der Anwendungsdaten wird **PostgreSQL** verwendet.

PostgreSQL läuft innerhalb der Docker-Compose-Umgebung als eigener Container.

Die Spring-Boot-Anwendung kommuniziert innerhalb des Docker-Netzwerks mit der Datenbank.

Die Architektur sieht vereinfacht folgendermaßen aus:

```text
Client
   |
   v
Spring Boot REST API
   |
   v
PostgreSQL
```

Dadurch bleiben Daten unabhängig vom Lebenszyklus des Anwendungscontainers persistent gespeichert, sofern ein entsprechendes Docker-Volume verwendet wird.

---

# Docker Swarm

Zusätzlich wird Docker Swarm als Container-Orchestrierungsfunktion verwendet.

## Docker Swarm initialisieren

```bash
docker swarm init
```

---

## Swarm-Status anzeigen

```bash
docker node ls
```

Damit können die Nodes des Docker-Swarm-Clusters angezeigt werden.

---

# Portainer

Für die grafische Verwaltung und Überwachung der Docker-Umgebung wird **Portainer Community Edition** verwendet.

Portainer ermöglicht die Verwaltung verschiedener Docker-Ressourcen über eine Weboberfläche.

Dazu gehören:

- Container
- Images
- Stacks
- Networks
- Volumes
- Logs
- Docker Swarm

---

## Portainer öffnen

Die Portainer-Weboberfläche ist lokal über folgende Adresse erreichbar:

```text
https://localhost:9443
```

Da Portainer lokal mit HTTPS betrieben wird, kann der Browser beim ersten Aufruf eine Zertifikatswarnung anzeigen.

---

# REST API

Die Anwendung stellt eine REST-Schnittstelle zur Verwaltung von Tasks bereit.

---

## Startseite

```http
GET /
```

Aufruf:

```text
http://localhost:8080
```

---

## Alle Aufgaben abrufen

```http
GET /api/tasks
```

Aufruf:

```text
http://localhost:8080/api/tasks
```

Eine mögliche Antwort ohne vorhandene Tasks ist:

```json
[]
```

---

# Anwendung mit Docker Compose starten

Für einen vollständigen lokalen Start der Umgebung kann folgender Befehl verwendet werden:

```bash
docker compose up --build -d
```

Danach können die laufenden Container überprüft werden:

```bash
docker compose ps
```

---

## Anwendung öffnen

```text
http://localhost:8080
```

---

## REST API öffnen

```text
http://localhost:8080/api/tasks
```

---

## Portainer öffnen

```text
https://localhost:9443
```

---

# Überprüfung des Deployments

Nach einem erfolgreichen Deployment kann die Umgebung mit folgenden Befehlen kontrolliert werden:

```bash
docker ps
```

oder:

```bash
docker compose ps
```

Zusätzlich können die Logs überprüft werden:

```bash
docker compose logs
```

Die REST API kann anschließend über den Browser oder ein API-Testwerkzeug aufgerufen werden.

---

# Git-Workflow

Für die Entwicklung können Feature-Branches verwendet werden.

Beispiel:

```bash
git checkout -b feature/neue-funktion
```

Änderungen hinzufügen:

```bash
git add .
```

Commit erstellen:

```bash
git commit -m "Neue Funktion hinzufügen"
```

Branch hochladen:

```bash
git push origin feature/neue-funktion
```

Anschließend kann auf GitHub ein Pull Request erstellt werden.

Nach erfolgreicher Prüfung können die Änderungen in den `main`-Branch übernommen werden.

---

# CI/CD-Ergebnis

Ein erfolgreicher GitHub-Actions-Workflow besteht aus den beiden Hauptjobs:

```text
✓ Build, Test & Docker
        |
        v
✓ Deployment mit Docker Compose
```

Wenn beide Jobs erfolgreich abgeschlossen wurden, zeigt GitHub Actions den Workflow-Status:

```text
Success
```

Damit ist sichergestellt, dass die Anwendung erfolgreich gebaut, getestet und anschließend über den Self-hosted Runner deployed werden konnte.

---

# Screenshots für die Dokumentation

Für die Projektdokumentation und Präsentation eignen sich insbesondere Screenshots von:

- GitHub Repository
- GitHub Actions Pipeline
- erfolgreichem Build-Job
- erfolgreichem Deployment-Job
- Self-hosted GitHub Actions Runner
- Windows-Service des Runners
- Docker Desktop
- laufenden Docker-Containern
- Docker Compose
- Portainer Dashboard
- Portainer Stacks
- Container Logs
- Docker Swarm
- REST API
- Anwendung im Browser
- PostgreSQL-Container

Ein besonders wichtiger Nachweis ist der erfolgreiche GitHub-Actions-Workflow:

```text
Build, Test & Docker             ✓
Deployment mit Docker Compose   ✓
Status: Success
```

---

# DevOps-Ziele des Projekts

Mit diesem Projekt werden verschiedene zentrale DevOps-Prinzipien praktisch umgesetzt:

- Versionsverwaltung mit Git
- zentrale Zusammenarbeit über GitHub
- automatisierte Builds
- automatisierte Tests
- Continuous Integration
- automatisiertes Deployment
- Containerisierung
- reproduzierbare Laufzeitumgebung
- Verwaltung mehrerer Services mit Docker Compose
- Self-hosted CI/CD-Infrastruktur
- persistente Datenspeicherung
- Monitoring und Verwaltung mit Portainer
- grundlegende Container-Orchestrierung mit Docker Swarm

---

# Zusammenfassung

Die **DevOps Student API** verbindet eine Spring-Boot-Anwendung mit einer containerisierten und automatisierten DevOps-Umgebung.

GitHub Actions übernimmt Build und Tests und erstellt das Docker-Image.

Für das Deployment wird ein Self-hosted GitHub Actions Runner auf einem Windows-System eingesetzt. Der Runner ist als Windows-Service eingerichtet und kann Deployment-Jobs auf der lokalen Docker-Umgebung ausführen.

Docker Compose übernimmt das Starten und Aktualisieren der benötigten Services. PostgreSQL dient als persistente Datenbank und Portainer ermöglicht die grafische Verwaltung und Überwachung der Docker-Infrastruktur.

Damit demonstriert das Projekt einen vollständigen DevOps-Prozess von der Codeänderung bis zur laufenden containerisierten Anwendung.

---

# Autor

**Nouaman Amri**

Technische Hochschule Mittelhessen (THM)  
Campus Friedberg

**Modul:** Software Development and Operations  
**Jahr:** 2026