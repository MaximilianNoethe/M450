## Erklärung der Tools
- Docker Compose: Damit kann man mehrere Services lokal starten, zum Beispiel Backend und Datenbank. praktisch für die Entwicklung.

- Kubernetes: Genutzt wenn eine Anwendung größer wird. Kümmert sich um Starten, Stoppen und Skalieren von Containern. Eher für Staging und Produktion.

- Vagrant: Erstellt lokale virtuelle Maschinen. Gut wenn man eine Umgebung braucht welche sehr ähnlich wie die spätere Server Umgebung ist.

- Terraform: Wird verwendet um Infrastruktur automatisch zu erstellen. Vor allem für Staging und Produktion sinnvoll.

## Welche Lösung für wleche Umgebung?

| Umgebung | Lösung | Begründung |
|---|---|---|
| Development | Docker Compose oder Vagrant | Docker Compose ist schnell und einfach für die lokale Entwicklung. Vagrant ist sinnvoll wenn man mit einer VM arbeiten muss. |
| Testing | Docker Compose oder Kubernetes | Für einfache Tests reicht Docker Compose. Tests die möglichst gleich wie in der Produktion laufen sollen ist Kubernetes besser. |
| Staging | Kubernetes + Terraform | Staging sollte möglichst gleich wie Produktion sein. Terraform erstellt die Infrastruktur, Kubernetes deployed die App. |
| Production | Kubernetes + Terraform | Diese Lösung ist stabil skalierbar und gut für den Produktivbetrieb geeignet. |
