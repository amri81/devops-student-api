# DevOps Student API

## Projektübersicht

Die **DevOps Student API** ist eine Spring-Boot-Anwendung zur Verwaltung von DevOps-Aufgaben (Tasks).

Das Projekt wurde im Rahmen des Moduls **Software Development and Operations** entwickelt und demonstriert den Aufbau einer vollständigen lokalen CI/CD-Umgebung.

Im Mittelpunkt stehen:

- Versionsverwaltung mit Git und GitHub
- Ticketverwaltung mit GitHub Issues und GitHub Projects
- automatisierter Build
- automatisierte Tests
- Erstellung eines Docker-Images
- automatisches Deployment
- Containerisierung mit Docker
- Orchestrierung mehrerer Services mit Docker Compose
- persistente Datenspeicherung mit PostgreSQL
- statische Codeanalyse mit SonarQube
- Verwaltung der Container mit Portainer
- Deployment über einen Self-hosted GitHub Actions Runner

Die Anwendung wird als Docker-Container ausgeführt und über eine REST-API bereitgestellt.

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
- GitHub Issues
- GitHub Projects
- GitHub Pull Requests
- GitHub Actions
- Self-hosted GitHub Actions Runner
- Docker
- Docker Compose
- Docker Swarm
- SonarQube Community
- Portainer Community Edition
- Windows Service

---

# GitHub Repository

Repository:

https://github.com/amri81/devops-student-api

---

# Docker Hub Repository

Docker Hub:

https://hub.docker.com/r/nouamanamri/devops-student-api

---

# Projektstruktur

```text
.
├── .github/
│   └── workflows/
│       └── github-ci.yml
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
├── Dockerfile
├── compose.yaml
├── pom.xml
├── api-test.http
├── README.md
└── target/
```

Die wichtigsten Dateien sind:

### `github-ci.yml`

Enthält die Definition der GitHub-Actions-CI/CD-Pipeline.

### `Dockerfile`

Definiert das Docker-Image für die Spring-Boot-Anwendung.

### `compose.yaml`

Definiert die lokale Docker-Compose-Umgebung und die benötigten Services.

### `pom.xml`

Enthält die Maven-Konfiguration, Abhängigkeiten und Build-Konfiguration der Spring-Boot-Anwendung.

### `application.properties`

Enthält unter anderem die Konfiguration für die Verbindung zwischen Spring Boot und PostgreSQL.

---

# DevOps-Architektur

Das Projekt verbindet mehrere DevOps-Komponenten zu einer durchgängigen Toolchain.

Der grundlegende Ablauf sieht folgendermaßen aus:

```text
Developer
    |
    | Git Push / Pull Request
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
   +-----------------------+
   | Spring Boot           |
   | PostgreSQL            |
   | SonarQube             |
   | Portainer             |
   +-----------------------+
              |
              v
          REST API
```

Dadurch werden Versionsverwaltung, Build, Test, Containerisierung und Deployment miteinander verbunden.

---

# Rollenverteilung

Die Projektarbeit sieht unterschiedliche Verantwortungsbereiche vor.

Die Aufgaben können innerhalb der Gruppe auf folgende Bereiche verteilt werden:

| Bereich | Aufgaben |
|---|---|
| Versionierung und Ticketverwaltung | Git, GitHub, Branches, Pull Requests, Issues und Project Board |
| Build & Deployment | GitHub Actions, CI/CD-Pipeline und Self-hosted Runner |
| Infrastruktur | Docker, Docker Compose, PostgreSQL und Portainer |
| Qualitätssicherung | SonarQube und Analyse der Codequalität |
| Softwareentwicklung | Spring Boot, Maven und REST API |

Die einzelnen Arbeitsschritte werden über GitHub Issues und das GitHub Project Board nachvollziehbar dokumentiert.

---

# Git-Workflow

Für Änderungen am Projekt werden Feature-Branches verwendet.

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

Anschließend wird auf GitHub ein Pull Request erstellt.

Der Pull Request ermöglicht die Überprüfung der Änderungen und die Ausführung der CI-Pipeline.

Nach erfolgreicher Prüfung können die Änderungen in den `main`-Branch übernommen werden.

---

# GitHub Issues und Project Board

Für die Organisation und Dokumentation der Aufgaben werden **GitHub Issues** und **GitHub Projects** verwendet.

Das Project Board verwendet die Status:

```text
Todo
  |
  v
In Progress
  |
  v
Done
```

Im Projekt wurden unter anderem folgende Aufgaben dokumentiert:

- PostgreSQL-Persistenz integrieren
- CI/CD-Pipeline mit GitHub Actions einrichten
- README mit DevOps-Umgebung aktualisieren
- SonarQube-Codeanalyse integrieren

Nach erfolgreicher Umsetzung werden die jeweiligen Issues geschlossen und im Project Board in den Status **Done** verschoben.

Dadurch ist die Entwicklung des Projekts nachvollziehbar dokumentiert.

---

# CI/CD-Pipeline

Das Projekt verwendet **GitHub Actions** zur Automatisierung der CI/CD-Prozesse.

Die Pipeline besteht aus zwei Hauptjobs:

1. **Build, Test & Docker**
2. **Deployment mit Docker Compose**

Der zweite Job wird erst ausgeführt, wenn der erste Job erfolgreich abgeschlossen wurde.

---

## 1. Build, Test & Docker

Bei einer entsprechenden Änderung im GitHub Repository wird die CI-Pipeline automatisch gestartet.

Der erste Job führt unter anderem folgende Schritte aus:

1. Repository auschecken
2. Java 21 einrichten
3. Maven Wrapper vorbereiten
4. Maven Build durchführen
5. automatisierte Tests ausführen
6. Docker-Compose-Konfiguration prüfen
7. Docker-Image erstellen
8. Anwendung testweise starten
9. REST API testen
10. Docker-Image speichern
11. Docker-Image als GitHub-Actions-Artefakt hochladen

Der Build-Job muss erfolgreich abgeschlossen werden, bevor das Deployment gestartet wird.

---

# Continuous Integration

Continuous Integration bedeutet in diesem Projekt, dass Änderungen am Quellcode automatisch überprüft werden.

Der vereinfachte Ablauf lautet:

```text
Codeänderung
     |
     v
Git Push / Pull Request
     |
     v
GitHub Actions
     |
     v
Maven Build
     |
     v
Automatisierte Tests
     |
     v
Docker Image
```

Fehler beim Build oder bei den Tests führen dazu, dass die Pipeline fehlschlägt.

Dadurch können Probleme frühzeitig erkannt werden.

---

# 2. Deployment mit Docker Compose

Nach erfolgreichem Build wird der Deployment-Job ausgeführt.

Für das Deployment wird ein **Self-hosted GitHub Actions Runner** verwendet.

Der Deployment-Prozess umfasst:

1. Repository auschecken
2. erzeugtes Docker-Image herunterladen
3. Docker-Image auf dem Self-hosted Runner laden
4. Anwendung automatisch mit Docker Compose starten bzw. aktualisieren
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
Build & Tests
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
Deployment prüfen
   |
   v
Anwendung läuft
```

Damit werden Continuous Integration und Continuous Deployment miteinander verbunden.

---

# Continuous Deployment

Das Deployment erfolgt automatisch nach einem erfolgreichen Build.

Der Self-hosted Runner übernimmt das erzeugte Docker-Image und stellt die Anwendung über Docker Compose bereit.

Dadurch ist im regulären CI/CD-Ablauf kein manuelles Starten der Anwendung notwendig.

```text
Build erfolgreich
       |
       v
Docker Image
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

Dadurch muss der Runner nicht bei jedem Deployment manuell mit

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

Der Runner steht dadurch dauerhaft für GitHub Actions als Deployment-Umgebung zur Verfügung.

---

# Docker

Die Spring-Boot-Anwendung wird als Docker-Image containerisiert.

Dadurch wird eine reproduzierbare Laufzeitumgebung geschaffen.

## Docker-Image erstellen

```bash
docker build -t devops-student-api:latest .
```

## Docker-Images anzeigen

```bash
docker images
```

## Docker-Container starten

```bash
docker run -p 8080:8080 devops-student-api:latest
```

## Laufende Container anzeigen

```bash
docker ps
```

## Alle Container anzeigen

```bash
docker ps -a
```

---

# Docker Compose

Docker Compose wird verwendet, um die benötigten Services gemeinsam zu starten und zu verwalten.

Die lokale DevOps-Umgebung umfasst:

- Spring-Boot-Anwendung
- PostgreSQL
- SonarQube
- Portainer

Die Services laufen als voneinander getrennte Docker-Container.

## Docker-Compose-Umgebung starten

```bash
docker compose up --build -d
```

## Container anzeigen

```bash
docker compose ps
```

## Logs anzeigen

```bash
docker compose logs
```

Fortlaufende Logs:

```bash
docker compose logs -f
```

## Docker-Compose-Umgebung stoppen

```bash
docker compose down
```

---

# PostgreSQL

Für die persistente Speicherung der Anwendungsdaten wird **PostgreSQL 16** verwendet.

PostgreSQL läuft innerhalb der Docker-Compose-Umgebung als eigener Container.

Die Spring-Boot-Anwendung kommuniziert innerhalb des Docker-Netzwerks mit der Datenbank.

```text
Client
   |
   v
Spring Boot REST API
   |
   v
PostgreSQL
   |
   v
Docker Volume
```

Durch die Verwendung eines Docker-Volumes bleiben die Daten unabhängig vom Lebenszyklus des Anwendungscontainers gespeichert.

---

# REST API

Die Anwendung stellt eine REST-Schnittstelle zur Verwaltung von DevOps-Tasks bereit.

Die zentrale URL lautet:

```text
http://localhost:8080/api/tasks
```

---

## Alle Tasks abrufen

```http
GET /api/tasks
```

Beispiel:

```text
http://localhost:8080/api/tasks
```

Ohne gespeicherte Tasks kann die Antwort beispielsweise lauten:

```json
[]
```

Mit gespeicherten Daten beispielsweise:

```json
[
  {
    "description": "Docker Compose konfigurieren",
    "id": 2
  }
]
```

---

## Task erstellen

Ein neuer Task kann über einen POST-Request erstellt werden.

Endpoint:

```http
POST /api/tasks
```

Beispiel mit PowerShell:

```powershell
Invoke-RestMethod `
  -Uri "http://localhost:8080/api/tasks" `
  -Method POST `
  -ContentType "text/plain" `
  -Body "Docker Compose konfigurieren"
```

Der Task wird anschließend in PostgreSQL gespeichert.

---

## Task löschen

Ein Task kann anhand seiner ID gelöscht werden.

Beispiel:

```http
DELETE /api/tasks/2
```

---

# SonarQube

Als optionale Erweiterung wurde **SonarQube Community** zur statischen Codeanalyse integriert.

SonarQube läuft als eigener Docker-Container innerhalb der lokalen DevOps-Umgebung.

Die Weboberfläche ist lokal erreichbar über:

```text
http://localhost:9001
```

Das Spring-Boot-Projekt wurde mit Maven analysiert.

Dabei werden unter anderem folgende Qualitätsbereiche untersucht:

- Security
- Reliability
- Maintainability
- Code Duplication
- Code Coverage
- mögliche Code-Probleme

---

## SonarQube-Ergebnis

Die durchgeführte Analyse des Projekts war erfolgreich.

Ergebnis:

| Metrik | Ergebnis |
|---|---|
| Quality Gate | Passed |
| Security | A |
| Reliability | A |
| Maintainability | A |
| offene Security-Probleme | 0 |
| offene Reliability-Probleme | 0 |
| offene Maintainability-Probleme | 0 |
| Duplications | 0.0 % |
| Test Coverage | aktuell 0.0 % |

Das **Quality Gate wurde bestanden**.

Die Test Coverage wird aktuell noch nicht über JaCoCo an SonarQube übertragen und wird deshalb mit `0.0 %` angezeigt.

SonarQube dient damit als zusätzliche Qualitätssicherung innerhalb der DevOps-Toolchain.

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

Portainer ist lokal unter anderem über folgenden Port erreichbar:

```text
http://localhost:9000
```

Alternativ steht die HTTPS-Oberfläche zur Verfügung:

```text
https://localhost:9443
```

Im Portainer Dashboard können die laufenden Container der DevOps-Umgebung kontrolliert werden.

Dazu gehören beispielsweise:

```text
devops-postgres
devops-student-apidocker
portainer
sonarqube
```

---

# Docker Swarm

Zusätzlich wurde Docker Swarm als Container-Orchestrierungsfunktion aktiviert.

## Docker Swarm initialisieren

```bash
docker swarm init
```

## Swarm-Status anzeigen

```bash
docker node ls
```

Docker Swarm ist eine zusätzliche Erweiterung des Projekts und nicht Voraussetzung für das grundlegende Docker-Compose-Deployment.

---

# Anwendung lokal starten

## Repository klonen

```bash
git clone https://github.com/amri81/devops-student-api.git
cd devops-student-api
```

---

## Projekt mit Maven bauen

Linux/macOS:

```bash
./mvnw clean package
```

Windows:

```powershell
.\mvnw.cmd clean package
```

Nach erfolgreichem Build befindet sich die erzeugte JAR-Datei im Verzeichnis:

```text
target/
```

---

## Gesamte Umgebung starten

```bash
docker compose up --build -d
```

Danach können die laufenden Container überprüft werden:

```bash
docker compose ps
```

---

# Lokale Services

Nach dem Start stehen unter anderem folgende Dienste zur Verfügung:

| Service | Adresse |
|---|---|
| Spring Boot REST API | `http://localhost:8080/api/tasks` |
| SonarQube | `http://localhost:9001` |
| Portainer HTTP | `http://localhost:9000` |
| Portainer HTTPS | `https://localhost:9443` |
| PostgreSQL | `localhost:5432` |

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

Die Logs können ebenfalls überprüft werden:

```bash
docker compose logs
```

Anschließend kann die REST API aufgerufen werden:

```text
http://localhost:8080/api/tasks
```

Ein erfolgreicher API-Aufruf zeigt, dass die Anwendung nach dem Deployment erreichbar ist.

---

# CI/CD-Ergebnis

Ein erfolgreicher GitHub-Actions-Workflow besteht aus den beiden Hauptjobs:

```text
✓ Build, Test & Docker
        |
        v
✓ Deployment mit Docker Compose
```

Nach erfolgreichem Abschluss zeigt GitHub Actions:

```text
Status: Success
```

Damit ist nachgewiesen, dass die Anwendung:

1. gebaut,
2. getestet,
3. als Docker-Image erstellt,
4. als Artefakt übertragen,
5. auf dem Self-hosted Runner geladen,
6. automatisch über Docker Compose deployed und
7. anschließend überprüft

werden kann.

---

# Reproduzierbarkeit

Ein wichtiges Ziel des Projekts ist eine reproduzierbare lokale CI/CD-Umgebung.

Die benötigte Infrastruktur wird hauptsächlich über folgende Dateien definiert:

```text
pom.xml
Dockerfile
compose.yaml
.github/workflows/github-ci.yml
```

Dadurch können Build, Containerisierung und Deployment nachvollziehbar reproduziert werden.

Initiale Einrichtungsschritte wie die Registrierung des Self-hosted Runners und die Einrichtung lokaler Zugangsdaten müssen einmalig durchgeführt werden.

Der reguläre CI/CD-Prozess läuft anschließend automatisiert.

---

# Herausforderungen und Fehleranalyse

Während der Umsetzung des Projekts traten verschiedene technische Herausforderungen auf.

## 1. Maven Wrapper in GitHub Actions

Beim Aufbau der Pipeline gab es zunächst Probleme mit der Ausführung des Maven Wrappers.

Die Pipeline wurde entsprechend angepasst, sodass Maven Build und Tests anschließend erfolgreich ausgeführt werden konnten.

### Erkenntnis

CI-Umgebungen können sich von der lokalen Entwicklungsumgebung unterscheiden. Dateiberechtigungen und Betriebssystemunterschiede müssen deshalb berücksichtigt werden.

---

## 2. PostgreSQL-Persistenz

Die Anwendung wurde von einer einfachen Spring-Boot-Anwendung zu einer Anwendung mit persistenter PostgreSQL-Datenbank erweitert.

Dabei mussten:

- Datenbankverbindung
- Docker-Netzwerk
- PostgreSQL-Service
- Persistenz
- Spring-Boot-Konfiguration

aufeinander abgestimmt werden.

### Lösung

PostgreSQL wurde als eigener Docker-Compose-Service integriert und über ein Docker-Volume persistent gemacht.

---

## 3. Automatisches Deployment

Eine wichtige Herausforderung war, dass das Deployment nicht nur lokal manuell funktionieren sollte.

Das Docker-Image musste vom CI-Job an die Deployment-Umgebung übertragen werden.

### Lösung

Das erzeugte Docker-Image wird als GitHub-Actions-Artefakt gespeichert.

Der Self-hosted Runner lädt dieses Artefakt anschließend herunter, lädt das Docker-Image und führt das Deployment mit Docker Compose aus.

---

## 4. Self-hosted Runner

Der Self-hosted Runner musste zuverlässig verfügbar sein, damit der Deployment-Job ausgeführt werden kann.

Ein manuelles Starten des Runners vor jedem Deployment wäre für einen automatisierten CI/CD-Prozess ungeeignet.

### Lösung

Der Runner wurde als Windows-Service eingerichtet.

Dadurch steht er GitHub Actions dauerhaft als lokale Deployment-Umgebung zur Verfügung.

---

## 5. SonarQube

Bei der Qualitätssicherung musste SonarQube mit dem Spring-Boot-Projekt verbunden und die Analyse über Maven ausgeführt werden.

Die Analyse konnte erfolgreich durchgeführt werden und das Quality Gate wurde bestanden.

Die Test Coverage wird aktuell noch mit `0.0 %` angezeigt, da noch keine JaCoCo-Coverage-Berichte integriert wurden.

### Erkenntnis

Statische Codeanalyse und Test Coverage sind unterschiedliche Qualitätsmetriken. Eine erfolgreiche SonarQube-Analyse bedeutet nicht automatisch, dass Coverage-Daten vorhanden sind.

---

# Lessons Learned / Reflexion

Durch das Projekt konnten verschiedene zentrale DevOps-Prinzipien praktisch umgesetzt werden.

## Automatisierung

Ein wesentliches Learning war, dass eine CI/CD-Pipeline viele manuelle Arbeitsschritte automatisieren kann.

Statt Build, Tests, Docker-Image-Erstellung und Deployment einzeln auszuführen, werden diese Schritte über GitHub Actions miteinander verbunden.

## Containerisierung

Docker ermöglicht eine reproduzierbare Laufzeitumgebung.

Dadurch wird die Anwendung unabhängig von vielen lokalen Systemeinstellungen ausgeführt.

## Docker Compose

Docker Compose erleichtert die Verwaltung mehrerer zusammengehöriger Services.

Spring Boot, PostgreSQL, SonarQube und Portainer können dadurch gemeinsam betrieben werden.

## Continuous Integration

Automatisierte Builds und Tests helfen dabei, Fehler nach Änderungen frühzeitig zu erkennen.

## Continuous Deployment

Durch den Self-hosted Runner konnte ein automatisches Deployment auf eine lokale Docker-Umgebung umgesetzt werden.

Dadurch wurde deutlich, wie CI und CD technisch miteinander verbunden werden können.

## Persistenz

Durch PostgreSQL und Docker Volumes wurde deutlich, dass Anwendungscontainer und persistente Daten getrennt behandelt werden sollten.

## Codequalität

SonarQube zeigt, dass neben funktionierendem Code auch Aspekte wie Security, Reliability und Maintainability Teil eines professionellen Entwicklungsprozesses sind.

## Versionsverwaltung

Feature-Branches, Pull Requests und Issues verbessern die Nachvollziehbarkeit von Änderungen.

Das GitHub Project Board ermöglicht zusätzlich eine übersichtliche Darstellung des Bearbeitungsstatus.

---

# DevOps-Ziele des Projekts

Mit diesem Projekt wurden verschiedene zentrale DevOps-Prinzipien praktisch umgesetzt:

- Versionsverwaltung mit Git
- zentrale Zusammenarbeit über GitHub
- Feature-Branches
- Pull Requests
- Ticketverwaltung mit GitHub Issues
- Aufgabenorganisation mit GitHub Projects
- automatisierte Builds
- automatisierte Tests
- Continuous Integration
- automatisiertes Deployment
- Continuous Deployment
- Containerisierung
- reproduzierbare Laufzeitumgebung
- Docker Compose
- Self-hosted CI/CD-Infrastruktur
- persistente Datenspeicherung mit PostgreSQL
- statische Codeanalyse mit SonarQube
- Monitoring und Verwaltung mit Portainer
- grundlegende Container-Orchestrierung mit Docker Swarm
- Fehleranalyse und iterative Verbesserung

---

# Screenshots für Dokumentation und Präsentation

Als Nachweise für die Umsetzung eignen sich insbesondere Screenshots von:

1. GitHub Repository
2. GitHub Issues
3. GitHub Project Board mit abgeschlossenen Tasks
4. Feature-Branches und Pull Requests
5. erfolgreichem GitHub-Actions-Workflow
6. Job **Build, Test & Docker**
7. Job **Deployment mit Docker Compose**
8. Self-hosted GitHub Actions Runner
9. Windows-Service des Runners
10. `docker compose ps`
11. REST API mit gespeichertem PostgreSQL-Task
12. SonarQube mit **Quality Gate Passed**
13. Portainer Dashboard
14. Portainer Container List
15. Portainer Stack
16. PostgreSQL-Container

Ein besonders wichtiger Nachweis ist der erfolgreiche GitHub-Actions-Workflow:

```text
Build, Test & Docker             ✓
Deployment mit Docker Compose   ✓
Status: Success
```

---

# Zusammenfassung

Die **DevOps Student API** verbindet eine Spring-Boot-Anwendung mit einer containerisierten und automatisierten DevOps-Umgebung.

Git und GitHub übernehmen die Versionsverwaltung. Issues, Projects, Feature-Branches und Pull Requests ermöglichen eine nachvollziehbare Organisation der Entwicklung.

GitHub Actions übernimmt Build und Tests und erstellt anschließend ein Docker-Image.

Das erzeugte Image wird als Artefakt an einen Self-hosted GitHub Actions Runner übertragen. Dieser führt das automatische Deployment über Docker Compose durch.

PostgreSQL ermöglicht die persistente Speicherung der Tasks.

SonarQube ergänzt die Umgebung um statische Codeanalyse und Qualitätssicherung.

Portainer ermöglicht die grafische Verwaltung und Überwachung der Docker-Infrastruktur.

Damit demonstriert das Projekt einen durchgängigen DevOps-Prozess:

```text
Plan
  ↓
Code
  ↓
Git / GitHub
  ↓
Build
  ↓
Test
  ↓
Docker Image
  ↓
Deployment
  ↓
Docker Compose
  ↓
Spring Boot + PostgreSQL
  ↓
Überprüfung / Monitoring
```

Das Projekt erfüllt damit die zentralen Anforderungen einer lokal ausführbaren und reproduzierbaren CI/CD-Umgebung.

---

# Autor

**Nouaman Amri**

Technische Hochschule Mittelhessen (THM)  
Campus Friedberg

**Modul:** Software Development and Operations  
**Jahr:** 2026
