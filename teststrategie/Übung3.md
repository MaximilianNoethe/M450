# Black-Box Testfälle
| ID  | Feature / Ziel                          | Vorbedingungen                                   | Eingabe / Schritte                                                                                                                                       | Erwartetes Resultat                                                                                                                                         |
|-----|-----------------------------------------|--------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1 | Konto erfolgreich erstellen (gültige Währung) | –                                          | 1. In `chooseAccount` `e` wählen  2. Nachnamen eingeben, z. B. `Müller`  3. Währung `CHF` eingeben                                                     | Neues Konto mit neuer ID, Nachname „Müller“, Währung `CHF`, Startsaldo 0.00, Kontodetails werden angezeigt, Bank hat ein Konto mehr.          |
| 2 | Erfolgreiche Einzahlung                   | Konto mit bekannter Nummer existiert            | 1. Konto in `chooseAccount` auswählen  2. In `editAccount` `e` (einzahlen) wählen  3. `100` eingeben                                                   | Kontostand wird um 100.00 in Kontowährung erhöht, neue Balance wird mit `printBalance` angezeigt.                                                          |
| 3 | Überweisung gleiche Währung (erfolgreich) | Zwei Konten mit gleicher Währung, Sender hat Deckung | 1. Konto A wählen  2. In `editAccount` `ü` wählen  3. Konto B als Ziel wählen  4. Betrag `200` eingeben                                              | Betrag wird von Konto A abgezogen und Konto B gutgeschrieben                                 |
| 4 | Konto löschen bestätigen                 | Konto existiert                                  | 1. Konto wählen  2. `l` in `editAccount` wählen  3. Bestätigung `j` eingeben                                                                           | Konto wird aus der `Bank` entfernt, Meldung „Konto mit Nummer X wurde gelöscht.“ wird ausgegeben.                                                          |
| 5 | Gültige Wechselkursabfrage              | Internetzugang, API erreichbar                   | 1. In `chooseAccount` `w` wählen  2. Eingabe `CHF USD`                                                                                                  | Es wird ein Kurs abgefragt und bei Erfolg Ausgabe „1 CHF = X USD“.                                                                                            |


# White-Box Testfälle
| ID | Feature / Ziel                 | Vorbedingungen                                     | Eingabe / Schritte                                   | Erwartetes Resultat                                                                                                   |
|----|--------------------------------|-----------------------------------------------------|-------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| 1  | `Account.deposit(double)`      | `amount > 0`, Startsaldo 100.00                     | `deposit(50)` → danach `getBalance()` aufrufen        | `getBalance()` liefert **150.00**                                                                                       |
| 2  | `Bank.createAccount`           | Mehrere Aufrufe mit verschiedenen Namen/Währungen    | Konto erstellen                                       | Jedes Konto wird zur internen `accounts`-Liste hinzugefügt; `id` wird korrekt hochgezählt                               |
| 3  | `chooseAccount`                | Verschiedene Eingaben testen (`a`, `w`, `e`, `q`, Zahl, ungültige Strings) | Eingabe über Menü                                     | Je nach Eingabe richtige Aktion: Liste anzeigen, Konto erstellen, Wechselkurs abrufen, Programm beenden, Fehlermeldung |
| 4  | `getExchangeRate("CHF","USD")` | HTTP-200, valides JSON                               | API-Call                                              | Rückgabewert entspricht `result` aus JSON und ist **> 0.0**                                                             |
                                                               


# Verbesserungen
- API-Key nicht hardcoden
- UI-Logik von Geschäftslogik trennen
- Validierungen verbessern
