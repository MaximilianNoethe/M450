## Übung 1 – Automatisierte Tests der REST-Schnittstelle

Für diese Übung wurde **Postman** verwendet, um die REST-Schnittstelle des Backends automatisiert zu testen.

### POST /students
Der POST-Request dient zur Erstellung eines neuen Users.

Request Body:
```json
{
  "name": "Postman Test User",
  "email": "postman.test.user1@example.com"
}
```

Der Request enthält automatisierte Tests (Status-Code, JSON-Response).
Alle Tests wurden erfolgreich ausgeführt.

Test erfolgreich:

<img width="2101" height="1113" alt="POST Test erfolgreich" src="https://github.com/user-attachments/assets/0c227ec4-0b4d-405b-b637-d73328547a9d" />
Collection Runner
Die Requests GET /students und POST /students wurden automatisiert über den Postman Collection Runner ausgeführt.

Alle Requests und Tests sind grün (PASS).

<img width="2252" height="905" alt="Collection Runner Ergebnis" src="https://github.com/user-attachments/assets/9c829b30-1f0c-4c8a-9bb5-51b341ace031" /> ```


## Übung 2 – End-to-End Frontend Tests

Diese Übung wurde nicht umgesetzt, da laut Aufgabenstellung bzw. mündlicher Anweisung kein Frontend implementiert werden musste.


## Übung 3 – Belastungstest der REST-Schnittstelle

### Ziel
Ziel dieser Übung war es, das Backend mit erhöhtem Traffic zu belasten und die Stabilität der REST-Schnittstelle zu überprüfen.

### Verwendetes Tool
Postman (Collection Runner)

### Testaufbau
- Endpoint: `GET /students`
- Base URL: `http://localhost:8081`
- Tool: Postman Collection Runner
- Iterations: 300
- Delay: 0 ms

### Konfiguration vor der Ausführung
<img width="2208" height="1282" alt="Postman Runner Konfiguration" src="https://github.com/user-attachments/assets/c31113f0-485f-428f-be16-5934bae4848a" />

### Durchführung
Der GET-Request wurde automatisiert über den Postman Collection Runner mehrfach hintereinander ausgeführt, um eine erhöhte Last auf das Backend zu simulieren.

### Ergebnis
<img width="2255" height="1410" alt="Postman Runner Resultat" src="https://github.com/user-attachments/assets/44fcdd78-30ea-438f-990f-61bbfae6c9ec" />

- 300 Requests erfolgreich ausgeführt
- Alle Tests **PASS**
- Keine Fehler (0 % Error Rate)
- Gesamtdauer ca. **3.5 Sekunden**

### Fazit
Die REST-Schnittstelle verhielt sich auch unter erhöhter Last stabil.
Es traten keine Fehler auf und die Antwortzeiten blieben im akzeptablen Bereich.

