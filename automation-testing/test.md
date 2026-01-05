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
