# 1 - Simpler Rechner

<img width="1724" height="485" alt="image" src="https://github.com/user-attachments/assets/c52d3abc-2b1a-4c4c-abdf-1b1530e1a062" />

<img width="2006" height="1119" alt="image" src="https://github.com/user-attachments/assets/15a6038a-0b47-44ed-9ccd-0a5cf129e616" />


# 2 - JUnit Zusammenfassung
## Was ist JUnit
JUnit ist ein Java Framework mit dem man Unit Tests schreibt und autamomatisch ausführt. Damit kann man einzelne Methoden testen um sicherzustellen dass sie genau das tun was sie sollen.

## Wichtige Features
- @Test -> Markiert eine Methode als Test
- Assertions -> Prüft man ob das Ergebnis stimmt
  - assertEquals(a,b)
  - assertTrue(x)
  - assertFalse(x)
  - assertNotNull(x)
- @BeforeEach -> Wird vor jedem Test ausgeführt
- @BeforeAll -> Wird einmal ausgeführt bevor alle Tests starten
- @Disabled -> Deaktiviert einen Test vorübergehend

## Typische Anwendungsfälle
- Methoden testen
- Fehlerfälle testen
- Fehlerfälle
- Berechnungne prüfen
- Wiederholende Setup-Arbeit automatisieren

## Referenz
https://www.vogella.com/tutorials/JUnit/article.html


# 3 - Banken Simulation
## Klassen und Zusammenhänge
### Bank
- Verwatungsklasse für alle Konten
- Hält eine Liste von Account Objekten
- Verantwortlich für:
  - createAccount()
  - deposit()
  - withdraw()
  - print()
  - printBalance()
- Beziehung:
  - Bank -> hat viele -> Accounts (0..n)

### Account
- Repräsentiert ein allgemeines Bankkonto.
- Attribute:
  - balance: long
  - id: String
- Methoden:
  - deposti()
  - withdraw()
  - canTransact()
  - print()
- Beziehung:
  - Booking -> gehört zu -> Account
  - SavingsAccount, SalaryAccount, PromoYoutSavingsAccount -> erben von -> Account

### Booking
- Repräsentiert eine einzelne Transaktion
- Attribute:
  - amount: long
  - id: int
- Methoden:
  - print()
- Wird von Account genutzt um Ein- und Auszahlungen zu protokollieren

### SavingsAccount
- Spezieller Kontotyp
- Überschreibt:
  - withdraw()

### SalaryAccount
- Lohnkonto
- Überschreibt:
  - print()
  - withdraw()

### PromoYouthSavingsAccount
- Spezielles Jugend Sparkonto
- Überschreibt:
  - deposit()

### BankUtils
- Hilfsklasse für Formatierungen
- Statische Kosntanten:
  - AMOUNT_FORMAT: DecimalFormat
  - TWO_DIGIT_FORMAT: DecimalFormat
- Methoden:
  - formatAmount()
  - formatBankDate()
- Wird von:
  - Account
  - Booking
  - Bank
  - usw.
 
### AccountBalanceComparator & AccountInverseBalanceComparator
- Sortierklassen um Konten nach Kontostand zu sortieren
- Können für Reportings verwendet werden

### Main
- Einstiegspunkt
- Initiaisiert eine Bank
- Erstellt Beispielkonten
- Ruft verschiedene Methoden der Bank auf

### Ablauf
1. Programmstart
2. Bank wird erstellt
3. Beispielkonten werden erstellt
4. Benutzer fürt Aktion aus
5. Jede Transaktion erzeugt eine Buchung Instanz
6. Ausgabe und Formatierung erfolgt über BankUtils

### Zusammenhänge
- Bank: verwaltet Konten
- Account: führt Buchungen aus
- Booking: speichert Transaktionen
- Verschiedene Accounttypen erben von Account und verändern einige Methoden
- BankUtils: ist eine reine Hilfsklasse
- Comporator Klassen: ermoglichen Sortieren von Konten

# 4 - Unit-Tests implementieren
