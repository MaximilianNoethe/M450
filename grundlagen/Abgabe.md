Aufgabe 1: 
- Unit Test: Testet die kleinste isolierbare Einheit (z. B. eine Funktion, Methode oder Klasse). Ziel ist es, die interne Logik und Korrektheit der einzelnen Bausteine sicherzustellen.
- Integrationstest: Testet das Zusammenspiel von zwei oder mehr Modulen oder Komponenten. Ziel ist die Überprüfung der Schnittstellen und des Datenflusses zwischen den Komponenten.
- Systemtest: Testet das gesamte, vollständig integrierte System anhand der funktionalen und nicht-funktionalen Anforderungen (z. B. Performance, Sicherheit). Ziel ist die Validierung des Gesamtsystems.
- Abnahmetest: Testet, ob die Software die Bedürfnisse und Anforderungen des Endbenutzers oder Kunden erfüllt. Oft wird hierfür die reale Geschäftsumgebung simuliert.

Aufgabe 2:
Beispiel SW-Mangel: Ein Kunde bestellt eine neue interne CRM-Software und fordert, dass alle Berichte maximal 5 Sekunden zum Laden benötigen. Nach der Auslieferung funktioniert die Berichterstellung zwar korrekt, benötigt aber bei großen Datensätzen 15 bis 20 Sekunden.

Beispiel SW-Fehler: Der Ausfall des Handelssystems Knight Capital Group: Ein automatisiertes Hochfrequenz-Handelssystem des US-Finanzdienstleisters Knight Capital Group wurde mit neuem Code aktualisiert. Ein Deployment-Fehler führte dazu, dass älterer, fehlerhafter Code, der für Testzwecke gedacht war, im Produktionssystem aktiviert wurde.

Aufgabe 3 Bonus:

Dieser Code 
```
if (extras >= 3)
    addon_discount = 10;
else if (extras >= 5)
    addon_discount = 15;
```

sollte zu:
```
if (extras >= 5)    
    addon_discount = 15;    
else if (extras >= 3)      
    addon_discount = 10; 
```
werden
