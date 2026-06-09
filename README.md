# DevOps Demo - Spring Boot Task API

## Projektübersicht

Dieses Repository enthält eine funktionsfähige Spring‑Boot‑Anwendung mit einer REST‑API zur Verwaltung von Aufgaben. Der Fokus liegt auf CI/CD mit GitHub Actions und Docker Hub sowie automatisierter Containerisierung.

Das Projekt dient als praktisches Beispiel für den **DevOps-Workflow**:
- Lokale Entwicklung mit Git/GitHub
- Automatisierte Tests und Builds via GitHub Actions
- Docker-Containerisierung und Push zu Docker Hub
- Einfache Nutzung für Tester über Docker Desktop

---

## 🔧 Voraussetzungen

### Für Tester (Docker Desktop erforderlich)
- **Docker Desktop** - [Download](https://www.docker.com/products/docker-desktop/)
  - Windows: Docker Desktop für Windows
  - Empfohlene Version: 29.x oder höher

### Für Entwickler (lokale Entwicklung)
- **Java Development Kit (JDK) 21** - [Eclipse Temurin](https://adoptium.net/temurin/releases/?version=21) oder [Oracle JDK](https://www.oracle.com/de/java/technologies/downloads/)
- **Apache Maven** - [Download](https://maven.apache.org/download.cgi)
- **Git** - [Download](https://git-scm.com/downloads)
- **Docker Desktop** (optional für lokale Container)

### Tech Stack (getestete Versionen)
- **JDK:** 21.0.9
- **Apache Maven:** 3.9.11
- **Docker Desktop:** 29.1.2
- **IDE:** Visual Studio Code
  - [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)
  - [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
  - [REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client)
  - [GitHub Actions](https://marketplace.visualstudio.com/items?itemName=github.vscode-github-actions)
- **Git-Client:** [GitHub Desktop](https://desktop.github.com/)

---

## 🚀 Schnellstart für Tester (nur Docker Desktop)

Die Anwendung kann direkt aus Docker Hub gezogen und gestartet werden. Der Quellcode muss **nicht** geklont werden.

### Start über Docker Hub

1. **Docker Desktop starten**

2. **Im Terminal ausführen:**

```bash
# Image von Docker Hub pullen
docker pull devrobin99/task-api:latest

# Container starten
docker run -p 8080:8080 --name task-api devrobin99/task-api:latest
```

3. **Im Browser öffnen:**
   - **Startseite:** http://localhost:8080/
   - **Task-API:** http://localhost:8080/api/tasks

Die Startseite enthält einen Link zur REST-API, über den direkt zur API navigiert werden kann.

---

## 🌐 REST‑API und Endpunkte

### Startseite

Zeigt die Willkommensseite mit einem klickbaren Link zur Task-API.

**Im Browser:** http://localhost:8080/

---

### Task-API

#### Alle Tasks abrufen (GET)
```bash
curl http://localhost:8080/api/tasks
```

**Im Browser:** http://localhost:8080/api/tasks

**Antwort-Beispiel:**
```json
[]
```

#### Neuen Task hinzufügen (POST)
```bash
curl -X POST http://localhost:8080/api/tasks -H "Content-Type: text/plain" -d "Einkaufen"
```

**Antwort:**
```
Task added: Einkaufen
```

**Hinweis:** POST-Anfragen können nur über Terminal/curl oder REST-Client-Tools getestet werden, nicht direkt im Browser.

#### Task löschen (DELETE)
```bash
curl -X DELETE http://localhost:8080/api/tasks/0
```

Löscht den Task mit Index 0 (erster Task).

**Hinweis:** DELETE-Anfragen können nur über Terminal/curl oder REST-Client-Tools getestet werden, nicht direkt im Browser.

---

## 🔄 Workflow-Beispiel

```bash
# 1. Task hinzufügen
curl -X POST http://localhost:8080/api/tasks -H "Content-Type: text/plain" -d "Aufgabe 1"

# 2. Zweiten Task hinzufügen
curl -X POST http://localhost:8080/api/tasks -H "Content-Type: text/plain" -d "Aufgabe 2"

# 3. Alle Tasks abrufen
curl http://localhost:8080/api/tasks

# 4. Ersten Task löschen
curl -X DELETE http://localhost:8080/api/tasks/0

# 5. Verbleibende Tasks anzeigen
curl http://localhost:8080/api/tasks
```

**Hinweis:** Alle GET-Anfragen können direkt im Browser getestet werden. POST/DELETE-Anfragen benötigen Terminal/curl oder REST-Client-Tools.

---

## 💻 Technologie‑Stack

- **Programmiersprache:** Java 21 (Eclipse Temurin)
- **Framework:** Spring Boot
- **Build-Tool:** Apache Maven
- **Containerisierung:** Docker
- **CI/CD:** GitHub Actions
- **Docker Hub:** devrobin99/task-api
- **Versionsverwaltung:** Git / GitHub

---

## 📁 Projektstruktur

```
.
├── .github/
│   └── workflows/
│       └── github-ci.yml          # GitHub Actions CI/CD Pipeline
├── .mvn/                          # Maven Wrapper Konfiguration
├── .vscode/                       # VS Code Einstellungen
├── src/
│   ├── main/
│   │   ├── java/de/devops/demo/
│   │   │   ├── DemoApplication.java       # Spring Boot Hauptklasse
│   │   │   ├── HelloController.java       # Startseite mit Link zur API
│   │   │   └── TaskController.java        # REST-API (/api/tasks)
│   │   └── resources/
│   │       └── application.properties     # Konfiguration
│   └── test/
│       └── java/de/devops/demo/
│           └── DemoApplicationTests.java  # Unit-Tests
├── target/                        # Kompilierte Dateien (generiert)
├── .gitattributes                 # Git Attribute
├── .gitignore                     # Git Ignore Regeln
├── Dockerfile                     # Docker Image Definition
├── api-test.http                  # HTTP-Testdatei für REST-API
├── mvnw                           # Maven Wrapper (Linux/Mac)
├── mvnw.cmd                       # Maven Wrapper (Windows)
├── pom.xml                        # Maven Konfiguration
└── README.md                      # Diese Datei
```

### Controller-Beschreibungen

**HelloController.java:**
- Stellt die Startseite unter `/` bereit
- Enthält einen HTML-Link zur Task-API (`/api/tasks`)
- Ermöglicht direkte Navigation zur API

**TaskController.java:**
- Verwaltet alle Tasks unter `/api/tasks`
- Unterstützt GET (Alle auslesen), POST (Hinzufügen), DELETE (Löschen)
- Nutzt In-Memory-Speicherung (keine externe Datenbank)

### Wichtige Dateien

**Maven Wrapper (`mvnw` / `mvnw.cmd`):**
- Ermöglicht Maven-Befehle ohne globale Maven-Installation
- `./mvnw clean package` (Linux/Mac)
- `.\mvnw.cmd clean package` (Windows)

**API-Test (`api-test.http`):**
- VS Code Extension REST Client oder ähnliches benötigt
- Schnelle Testmöglichkeit für REST-Endpunkte

**GitHub Actions (`github-ci.yml`):**
- Automatisierter Build/Test bei Push und Pull Request
- Docker-Push nur manuell über `workflow_dispatch` (`Run workflow`)

---

## 🛠️ Lokale Entwicklung (ohne Docker)

### Repository klonen
```bash
git clone https://github.com/Robin9924/devops-task-api.git
cd devops-task-api
```

### Build durchführen (mit Maven Wrapper)
```bash
# Linux/Mac
./mvnw clean package

# Windows
.\mvnw.cmd clean package
```

### Anwendung starten
```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

Anwendung läuft unter:
- Startseite: http://localhost:8080/
- API: http://localhost:8080/api/tasks

### Tests ausführen
```bash
# Linux/Mac
./mvnw test

# Windows
.\mvnw.cmd test
```

---

## 🐳 Lokales Docker-Build

### Docker Image bauen
```bash
docker build -t task-api:latest .
```

### Container starten
```bash
docker run -p 8080:8080 --name task-api task-api:latest
```

### Container im Hintergrund starten
```bash
docker run -d -p 8080:8080 --name task-api task-api:latest
```

### Container stoppen und löschen
```bash
docker stop task-api
docker rm task-api
```

---

## ⚙️ CI/CD‑Pipeline mit GitHub Actions

Die Pipeline unterstützt automatische Qualitätsprüfungen und einen kontrollierten manuellen Release-Push:
- Build/Test automatisch bei Push und Pull Request auf `main`
- Docker-Push nur manuell über `workflow_dispatch`

### Workflow-Datei
- **Ort:** `.github/workflows/github-ci.yml`

### Pipeline-Schritte

1. **Build-Job (Continuous Integration)**
   - Checkout des Repositories
   - Setup von Java 21
   - Maven Tests ausführen
   - JAR-Artefakt erstellen
   - JAR als GitHub-Artifact speichern

2. **Docker-Build-Job (Containerisierung)**
   - Docker Image bauen basierend auf `Dockerfile`
   - Mit Docker Hub authentifizieren
   - Image mit neuem Tag versehen
   - Image zu Docker Hub pushen (`devrobin99/task-api:latest`)

### Erforderliche GitHub Secrets

Für den **sicheren** Docker Hub Push müssen folgende Secrets konfiguriert werden:

| Secret Name | Wert | Zweck |
|-------------|------|-------|
| `DOCKERHUB_USERNAME` | Docker Hub Username | Authentifizierung |
| `DOCKERHUB_TOKEN` | Docker Hub **Access Token** (nicht Passwort!) | Sichere Authentifizierung |

#### 🔐 **Sicherheitsmaßnahmen (2026)**

**1. Workflow-Schutz:**
- **Automatische Tests** bei jedem Push/PR (`build`-Job)
- **Docker Push NUR manuell** via `"Run workflow"` Button (`workflow_dispatch`)
- **Branch Protection** auf `main`: PR + Tests erforderlich vor Merge

**2. Push Protection aktiv:**
- **Account-weit**: Secrets (Tokens, Keys) blocken vor Push
- **GitHub blockt automatisch** versehentliche Leaks

**3. Secrets Setup:**
Settings → Secrets and variables → Actions
→ "New repository secret" → Namen/Werte eingeben

**4. Token-Erstellung (Docker Hub):**
Docker Hub → Account Settings → Settings → Personal access tokens 
→ "Generate new token" → Read/Write → Copy & als Secret speichern

**5. Audit-Logs:**
- **Actions Tab**: Alle Runs (Tests, Docker Pushes) protokolliert
- **Branch History**: PRs + Approvals nachvollziehbar

### Automatisierung
- **Trigger:** `build` automatisch bei Push/PR, Docker Push nur manuell via `workflow_dispatch`
- **Voraussetzung:** GitHub Actions aktiv, Secrets konfiguriert, Branch Protection für `main`
- **Ergebnis:** Kontinuierliche Qualitätssicherung und kontrollierte, nachvollziehbare Docker Releases

---

## 🧪 Tests

### Tests lokal ausführen
```bash
# Linux/Mac
./mvnw test

# Windows
.\mvnw.cmd test
```

### Test-Suite
- **Ort:** `src/test/java/de/devops/demo/`
- **Framework:** JUnit 5 + Spring Boot Test
- **Umfang:** Context-Load-Tests und grundlegende API-Tests

### In der CI-Pipeline
- Tests laufen automatisch bei jedem Push und jedem Pull Request
- Bei Fehlern wird der Build abgebrochen
- Docker Images werden nur bei manuellem Workflow-Start (`workflow_dispatch`) und erfolgreichem Build erzeugt und gepusht

---

## 📋 Zusammenfassung

✅ **Softwareentwicklung:** Spring Boot REST-API mit sauberer Maven-Struktur

✅ **Versionsverwaltung:** Git/GitHub mit Commits und History

✅ **CI/CD:** GitHub Actions mit automatisiertem Build/Test und manuellem, sicherem Docker-Push

✅ **Containerisierung:** Dockerfile für Docker Desktop und Docker Hub

✅ **Benutzerfreundlichkeit:** Startseite mit direktem Link zur API

✅ **Dokumentation:** Vollständige README für Installation und Nutzung

✅ **Maven Wrapper:** Build ohne globale Maven-Installation

✅ **API-Tests:** HTTP-Testdatei für schnelle REST-Endpunkt-Tests

---

## 🔗 Wichtige Links

- **GitHub Repository:** https://github.com/Robin9924/devops-task-api.git
- **Docker Hub:** https://hub.docker.com/r/devrobin99/task-api
- [Spring Boot Dokumentation](https://spring.io/projects/spring-boot)
- [Docker Dokumentation](https://docs.docker.com/)
- [GitHub Actions Dokumentation](https://docs.github.com/en/actions)
- [Maven Dokumentation](https://maven.apache.org/)

---

## 📝 Lizenz

Dieses Projekt dient zu Bildungszwecken im Rahmen des DevOps-Kurses.

---

## 👤 Projekt

DevOps Demo Projekt 2026

Gruppe 6:
- Kalender Dirik
- Sami Keilani
- Berhan Polat Arslan
- Amine Assatah
- Robin Schenk
