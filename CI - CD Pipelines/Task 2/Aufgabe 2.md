# Aufgabe 2
## Gewählte Softwarelösung
Docker Compose

## Gewählte Umgebung
Development Environment

## Zu deployende Software
recipe-planner-backend

## Was ich konkret gemacht habe
- Ein Dockerfile für das Backend erstellt.
- Eine docker-compose.yml für den lokalen Start erstellt.

Dateien:
- `CI - CD Pipelines/Task 1/recipe-planner-fronend-and-backend/recipe-planner-backend/Dockerfile`
- `CI - CD Pipelines/Task 2/docker-compose.yml`

Startbefehl:
```
cd "CI - CD Pipelines/Task 2"
docker compose up --build
```

## Probleme
- Wir hatten nur eine Lektion Zeit, daher blieb es beim einfachen Setup.
- Die Pfade im Repo sind lang (Spaces im Ordnernamen) das war verwirrend.
- Lokal musste Java/Maven korrekt eingerichtet sein und das hat viel Zeit gekostet.

## Fazit
Docker Compose ist für Development/Test sehr praktisch, weil es schnell und reproduzierbar ist.

Für Staging/Production würde ich eher Kubernetes + Terraform verwenden, weil dort Stabilität,
Skalierung und Infrastruktur‑Automation wichtiger sind.

Compose würde ich einsetzen, wenn ich lokal schnell starten möchte oder kleine Tests brauche.
