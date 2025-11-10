# Abstrakte Testfälle (Logik mit Operatoren)
| ID | Eingabe (Kaufpreis)      | Erwarteter Rabatt | Erwartete Berechnung                  |
| -- | ------------------------ | ----------------- | ------------------------ 
| A1 | `preis < 15000`          | 0%                | endpreis = preis         
| A2 | `15000 ≤ preis ≤ 20000`  | 5%                | endpreis = preis × 0.95  
| A3 | `20000 < preis < 25000`  | 7%                | endpreis = preis × 0.93  
| A4 | `preis ≥ 25000`          | 8.5%              | endpreis = preis × 0.915 
| A5 | `preis ≤ 0`              | Fehler            | Validierungsfehler       

# Konkrete Testfälle
| ID  |  Kaufpreis (CHF) | Rabatt % | Erwarteter Rabatt (CHF) | Erwarteter Endpreis (CHF) | Klasse 
| --- | ---------------: | -------: | ----------------------: | ------------------------: | ------ 
| C1  |             0.00 |        – |                       – |                **Fehler** | A5  
| C2  |        14’999.99 |        0 |                    0.00 |             **14’999.99** | A1  
| C3  |    **15’000.00** |        5 |                  750.00 |             **14’250.00** | A2  
| C4  |    **20’000.00** |        5 |                1’000.00 |             **19’000.00** | A2  
| C5  |    **20’000.01** |        7 |                1’400.00 |             **18’600.01** | A3  
| C6  |        22’000.00 |        7 |                1’540.00 |             **20’460.00** | A3  
| C7  |        24’999.99 |        7 |              1’749.9993 |             **23’249.99** | A3  
| C8  |    **25’000.00** |      8.5 |                2’125.00 |             **22’875.00** | A4  
| C9  |        40’000.00 |      8.5 |                3’400.00 |             **36’600.00** | A4  
