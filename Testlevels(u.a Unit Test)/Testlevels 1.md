# Software Testing – Google & Accenture

## Aufgabe 1 – Was wird wie in ihrer Firma getestet

### 🔹 Google
- **Test Levels:** Unit, Integration und End-to-End Tests  
- **Zeitpunkt:** Automatisiert bei jedem Commit (CI/CD) und manuell vor Releases  
- **QA Teams:** Keine dedizierten QA-Teams, Verantwortung liegt bei den Entwicklern  
- **Testing Lifecycle:**
  1. Code schreiben  
  2. Unit Tests lokal ausführen  
  3. Automatisierte Tests in Pipeline (z. B. Cloud Build)  
  4. Code Review & Merge  
  5. Integration- & E2E-Tests  
  6. Deployment & Monitoring  

---

### 🔹 Accenture
- **Test Levels:** System Tests, User Acceptance Tests, Regression Tests  
- **Zeitpunkt:** Nach jedem Sprint und vor Kundenabnahme  
- **QA Teams:** Dedizierte QA- und Automation-Teams (teilweise offshore)  
- **Testing Lifecycle:**
  1. Anforderungsanalyse  
  2. Testplanung  
  3. Testdurchführung  
  4. Fehlererfassung & Retesting  
  5. Abnahme durch Kunden  

---

## Aufgabe 2 – Begriffe & Zusammenhänge

| Begriff | Bedeutung | Zusammenhang |
|----------|------------|---------------|
| **Testing Approach** | Strategie, *wie* getestet wird (z. B. agile, risk-based, automation-first) | Grundlage für Levels & Types |
| **Testing Levels** | Phasen des Testens (Unit, Integration, System, UAT) | Bestimmen, **wann** getestet wird |
| **Testing Types** | Fokus des Tests (funktional, Performance, Security, Usability) | Wird auf verschiedenen Levels angewendet |
| **Testing Techniques** | Methoden zur Testfallentwicklung (Black-Box, White-Box, explorativ) | Unterstützt die Types |
| **Testing Tactics** | Konkrete Umsetzung (Mocking, Testdaten, Automation Scripts) | Umsetzung der Techniques |

